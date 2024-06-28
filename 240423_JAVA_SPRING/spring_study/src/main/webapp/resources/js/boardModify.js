document.addEventListener('click', (e)=>{
    if(e.target.classList.contains('file-x')){
        let uuid = e.target.dataset.uuid;
        console.log(uuid);
        deleteFileFromServer(uuid).then(result =>{
            if(result === "1"){
                alert("파일이 삭제되었습니다. ")
                e.target.closest('li').remove();
            }
        })
    }
});

async function deleteFileFromServer(uuid){
    try {
        const url = "/board/"+uuid;
        const config = {
            method : "delete"
        }
        const resp = await fetch(url,config);
        const result = resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}