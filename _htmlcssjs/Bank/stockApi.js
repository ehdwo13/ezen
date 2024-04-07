fetch("https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo?serviceKey=k6sw%2F8GB2DQAB5LIosKFvYRiGAyA8%2FhNnNAJFQ4h1wjM0ICvxQEZnr9xdjatBTNrmlLi%2FTJ%2Bf6cAYeLsQJ5%2BlA%3D%3D&numOfRows=3000&resultType=json&basDt=20240402")
.then(resp => resp.json()
.then(result => printData(result)))
.catch(err => console.log(err));
function printData(obj) {
    const request = indexedDB.open("stockDB");
    //mrktTotAmt 시가총액 vs 대비 fltRt 등락률 itmsNm 종목명 clpr 종가 srtnCd 종목코드
    request.onerror = function (event) {
        console.log("error occurred");
        console.log(event);
    };
    request.onsuccess = function () {
        const db = request.result;
        const transaction = db.transaction("id", "readwrite");
        const store = transaction.objectStore("id");
        let count = 0;
        //json 에서 받은 데이터추가
        for (let key of obj.response.body.items.item) {
            store.put({ id: count, itmsNm: `${key.itmsNm}`, mrktTotAmt: `${Number(key.mrktTotAmt)}`, vs: `${Number(key.vs)}`, fltRt: `${Number(key.fltRt)}`, clpr: `${key.clpr}`, srtnCd: `${key.srtnCd}`});
            count++;
        }
    };
}