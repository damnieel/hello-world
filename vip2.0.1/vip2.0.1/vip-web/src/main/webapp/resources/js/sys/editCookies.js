/**
 * 编辑Cookie
 * by 大枫
 */ 
function setCookie(name,value) 
{ 
    var Days = 1; 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*30*60*1000); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/"; 
} 
// 读取cookies
function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]); 
    else 
        return null; 
} 
function delCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString()+";path=/"; 
} 
function setLocalCookie(name,value) 
{ 
    var Days = 1; 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*30*60*1000); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=" + window.location.pathname; 
} 
function delLocalCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString()+";path=" + window.location.pathname; 
} 
