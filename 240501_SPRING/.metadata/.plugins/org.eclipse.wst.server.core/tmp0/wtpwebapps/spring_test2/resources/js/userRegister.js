document.getElementById('checkEmail').addEventListener('click', async () => {
    let email = document.getElementById('e').value;
    console.log(email);
    checkEmail(email).then(result=>{
        console.log(result);
        if (result == "1") {
            alert('중복된 이메일 입니다. 다시 입력해주세요.');
            document.getElementById('e').value = "";
        } else {
            alert('사용 가능한 이메일 입니다.');
        }
    })
});

async function checkEmail(email) {
    try {
        const url = "/user/check";
        const config = {
            method: "POST",
            body: email
        };
        const resp = await fetch(url, config);
        const result = await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}
    
