/**
 * Created by fever on 2017/3/31.
 */
function showInfo(obj) {
    var idCount=obj.id.substring(4);
    var upId="up"+idCount;
    var upElement =document.getElementById(upId);
    var trElement=document.getElementById("record"+idCount);
    obj.style.display="none";
    upElement.style.display="block";
    trElement.style.display="table-row";
}

function hiddenInfo(obj) {
    var idCount=obj.id.substring(2);
    var downId="down"+idCount;
    var downElement =document.getElementById(downId);
    var trElement=document.getElementById("record"+idCount);
    obj.style.display="none";
    downElement.style.display="block";
    trElement.style.display="none";
}