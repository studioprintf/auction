/**
 * Created by Dymond on 2017/4/10.
 */
$(function () {
    getMaxtime("2017-04-20 18:00:00");
})

function getServTime(){
    var time;
    $.ajax({type:'HEAD', async: true})
        .success(function(data, status, xhr){
            time=xhr.getResponseHeader('Date');
        });
    alert(time);
    alert(time.getTime());
    return time.getTime();
}

function getMaxtime(val) {
    var endTime = Date.parse(val);
    var servTime = new Date(getServTime());
    var maxTime = endTime.getTime()-servTime.getTime();
    alert(maxTime)
    return maxTime;
}

var maxtime = 60*60;//60*60 //一个小时，按秒计算，自己调整!
function CountDown(){//倒计时
    if(maxtime>=0){
        days = Math.floor(maxtime/86400);
        hours = Math.floor(maxtime/3600);
        minutes = Math.floor(maxtime/60);
        seconds = Math.floor(maxtime%60);
//msg = "距离结束还有"+minutes+"分"+seconds+"秒";
        msg = "距离结束还有"+seconds+"秒";
        document.all["timer"].innerHTML=msg;
        if(maxtime == 5*60){
            alert('注意，还有5分钟!');
        }
        --maxtime;
    }else{
        clearInterval(timer);
//alert("时间到，结束!");
        maxtime=60*60;
        timer = setInterval("CountDown()",1000);
    }
}
timer = setInterval("CountDown()",1000);
