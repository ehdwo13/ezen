//cmtAddBtn 버튼을 클릭하면 bno, writer, content를 비동기로 DB에 넣기
document.getElementById('cmtAddBtn').addEventListener('click', () => {
    // const cmtWriter = document.getElementById('cmtWriter').value;
    let cmtWriter = "Tester";
    let cmtText = document.getElementById('cmtText').value;
    console.log(cmtWriter);
    console.log(cmtText);

    if(cmtText == null || cmtText == ''){
        alert("댓글을 입력해주세요. ")
        document.getElementById('cmtText').focus();
        return false;
    }else{
        let cmtData = {
            bno : bnoVal,
            writer : cmtWriter,
            content : cmtText
        }
        postCommentToServer(cmtData).then(result => {
            if(result === "1"){
                alert("댓글 입력 성공");
                document.getElementById('cmtText').value = "";
                spreadList(bnoVal);
            }
        })
    }
});

async function postCommentToServer(cmtData){
    try {
        const url = '/comment/post';
        const config = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
        body: JSON.stringify(cmtData)
    };
    const resp = await fetch(url, config);
    const result = await resp.text();
    return result;
    } catch (error) {
        console.log(error);
    }
};

function spreadList(bno){
    getCommentListFromServer(bno).then(result =>{
        const ul = document.getElementById('cmtListArea');
        if(result.length > 0){
            ul.innerHTML = "";
            for(let cvo of result){
                let add = `<li class="list-group-item">`;
                add+= `<div class="input-group mb-3">`;
                add+= `<div class="fw-bold">${cvo.writer}</div>`;
                add+= `${cvo.content}`;
                add+= `</div>`;
                add+= `<span class="badge rounded-pill text-bg-warning">${cvo.regDate}</span><br>`;
                //수정, 삭제 버튼
                add += `<button type="button" class="btn btn-outline-warning btn-sm mod" data-bs-toggle="modal" data-bs-target="#myModal">수정</button>`;
                add += `<button type="button" class="btn btn-outline-danger btn-sm del">삭제</button>`;
                add+= `</li>`;
                ul.innerHTML += add;
            }
        }else{
            ul.innerHTML = `<li class="list-group-item"> Comment List Empty </li>`
        }
    })
}

async function getCommentListFromServer(bno){
    try {
        const resp = await fetch("/comment/"+bno);
        const result = await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}



