document.getElementById('trigger').addEventListener('click',()=>{
    document.getElementById('file').click();
})

//정규표현식을 사용하여 파일의 형식을 제한
//실행파일 막기(exe, bat, sh, mis, dll, jar)
//파일 사이즈 체크(20MB 보다 크면 막기)
//이미지 파일만 올리기(jpg, jpeg, gif, png, bmp)
const regExp = new RegExp("\.(exe|sh|bat|mis|dll|jar)$");
const regExpImg = new RegExp("\.(jpg|jpeg|gif|png|bmo)$");
const maxSize = 1024*1024*20;

//Validation : 규칙설정
//return 0 / 1로 리턴
function fileValidation(name, fileSize){
    let fileName = name.toLowerCase();  //파일 이름을 전부 소문자로 변경
    if(regExp.test(fileName)){
        return 0;
    }else if(fileSize > maxSize){
        return 0;
    }else if(!regExpImg.test(fileName)){
        return 0;
    }else{
        return 1;
    }
}

//첨부파일에 따라 등록이 가능한지 체크 함수
document.addEventListener('change',(e)=>{
    if(e.target.id == 'file'){
        //여러개의 파일이 배열로 들어옴
        const fileObject = document.getElementById('file').files;
        //한번 true가 된 disabled 는 다시 false로 돌아오지않음
        document.getElementById('regBtn').disabled = false;
        let div = document.getElementById('fileZone');
        div.innerHTML = '';
        let ul = `<ul class="list-group">`;
        //각각의 파일은 fileValidation에 의해 리턴 여부를 체크
        //모든 파일의 return의 값이 1이어야 가능
        // * 로 isOk를 처리하여 모든 파일이 1인지 체크
        let isOk = 1;
        
        for(let file of fileObject){
            let ValidResult = fileValidation(file.name, file.size);
            isOk *= ValidResult ;
            ul+=`<li class="list-group-item">`;
            ul+=`<div>${ValidResult ?'업로드 가능' : '업로드 불가능'}</div>${file.name}`;
            ul+=`<span class="badge text-bg-${ValidResult ? 'success' : 'danger'}">${file.size}</span>`;
            ul+=`</li>`;
        }
        ul += `</ul>`;
        div.innerHTML = ul;
        if(isOk == 0){
            document.getElementById('regBtn').disabled = true;  //비활성화
        }
    }
})
