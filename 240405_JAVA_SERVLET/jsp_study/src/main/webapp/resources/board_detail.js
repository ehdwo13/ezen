document.getElementById('cmtAddBtn').addEventListener('click',()=>{
    const cmtWriter = document.getElementById('cmtWriter').value;
    let cmtText = document.getElementById('cmtText').value;
    if(cmtText == null || cmtText== ''){
        alert("댓글을 입력해주세요. ")
        return false;
    }else{
        let cmtData = {
            bno : bnoVal,
            writer : cmtWriter,
            content : cmtText
        }
        postCommentToServer(cmtData).then(result =>{
            if(result === "1"){
                alert("댓글 등록 성공");
                document.getElementById('cmtText').value = " ";
            }
            printCommentList(bnoVal);
        })
    }
});

async function postCommentToServer(cmtData){
    try {
        const url = "/cmt/post";
        const config = {
            method : 'post',
            headers : {
                'Content-Type' : 'application/json; charset=utf-8'
            },
            body : JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
};

function spreadCommentList(result){
    let div = document.getElementById('commentLine');
    div.innerText = '';
    for(let i=0; i<result.length; i++){
        let html = `<div>`;
        html += `<div>${result[i].writer} | ${result[i].regdate} <input type="text" class="cmtText" value="${result[i].content}">`
        if(logVal == result[i].writer){
            html += `<button type="button" data-cno=${result[i].cno} class="cmtModBtn" id="cmtModBtn">수정</button><button type="button" data-cno=${result[i].cno} class="cmtDelBtn">삭제</button>`;
        }
        html += `</div></div><hr>`;
        div.innerHTML += html;
    }
}
async function getCommentListFromServer(bno){
    try {
        const resp = await fetch("/cmt/list?bno="+bno);
        const result = await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}
function printCommentList(bno){
    getCommentListFromServer(bno).then(result => {
        if(result.length > 0){
            spreadCommentList(result);
        }else{
            let div = document.getElementById('commentLine');
            div.innerHTML = `<div> 댓글이 없습니다. </div>`
        }
    })
}
document.addEventListener('click', (e)=>{
    if(e.target.classList.contains("cmtDelBtn")){
        let cnoVal = e.target.dataset.cno;
        removeCommentFromServer(cnoVal).then(result => {
            if(result === "1"){
                alert("댓글 삭제 성공")
                printCommentList(bnoVal);
            }
        })  
    }
    if(e.target.classList.contains("cmtModBtn")){
        let cnoVal = e.target.dataset.cno;
        let div = e.target.closest('div');
        let cmtText = div.querySelector('.cmtText').value;
        let cmtData = {
            cno : cnoVal,
            content : cmtText
        }
        updateCommentFromServer(cmtData).then(result =>{
            if(result === "1"){
                alert("댓글 수정 성공")
                printCommentList(bnoVal);
            }
        })
    }

})
async function removeCommentFromServer(cnoVal){
    try {
        const resp = await fetch("/cmt/remove?cno="+cnoVal);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error)
    }
}
async function updateCommentFromServer(cmtData){
    try {
        const url = "/cmt/modify";
        const config = {
            method : 'post',
            Headers : {
                'Content-Type' : 'application/json; charset=utf-8'
            },
            body : JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error)
    }
}