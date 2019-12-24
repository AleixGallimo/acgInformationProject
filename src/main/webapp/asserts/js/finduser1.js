
//
$(function () {
    $.ajax({
        url: "/luntan/UserController/findUserById",
        Type: "GET",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        data: {},
        success: function (data) {

            $("#div").empty();
            var html = '<div id="div">' +
                '<nav class="navbar navbar-default">' +
                '<div class="container-fluid">' +
                '<div class="navbar-header">' +
                '<a class="navbar-brand" href="#">' +
                //首页的入口
                '<a href="../views/Demo.html">'+
                '<img alt="Brand" src="../asserts/images/logo.png"' +
                'style="width: 100px;height: 100px; border-radius:80%; overflow:hidden;background-color: #00b9eb"></a>' +
                //充值的入口
                '<a href="../views/recharge.html">'+
                '<img alt="Brand" id="recharge" src="../asserts/images/Recharge.jpg"' +
                'style="right:300px; width: 100px;height: 100px; border-radius:80%; overflow:hidden;background-color: #00b9eb"></a>'+

                '</a>' +
                '</div></div></nav><div class="container"><header class="clearfix"><h1>个人资料</h1></header>' +
                <!--        头像-->
                /*'<img id="crown" src="../asserts/images/crown.jpg"  alt="皇冠图标" style="width: 200px; height:200px; border-radius:40%; overflow:hidden;hidden>'+*/
                '<div id="pic" style="text-align: center"><img src="../asserts/images/Icon.jpg" alt="头像" style="width: 200px; height:200px; border-radius:80%; overflow:hidden;></div>' +
                '<div style="text-align: right"><img src="../asserts/images/member.jpg" id="member" alt="升级会员入口" style="width: 200px; height:200px; border-radius:80%; overflow:hidden;position: absolute;right: 100px;top: 100px;></div>' +
                '<div class="><form class="cbp-mc-form"><div class="cbp-mc-column"><label for="uAccount">用户名</label>' +
                '<input type="text" value=' + data.uAccount + ' name="uAccount"id="uAccount">' +
                '<label for="uPassword">密码</label>' +
                '<input type="text" value=' + data.uPassword + ' name="uPassword"id="uPassword">' +
                '<label for="uEmail">电子邮箱</label>' +
                '<input type="text" value=' + data.uEmail + ' name="uEmail"id="uEmail">' +
                '<label for="uBrief">个人简介</label>' +
                '<textarea id="uBrief" name="uBrief">' + data.uBrief + '</textarea></div>' +
                '<div class="cbp-mc-column"><label for="uName">昵称</label>' +
                '<input type="text" name="uName"id="uName"value=' + data.uName+'>' +

                '<label for="uBirth">生日</label>' +
                '<input type="text" name="uBirth"id="uBirth"value=' + data.uBirth+'>' +

                '<label for="uMoney">余额(￥)</label>' +
                '<input type="text" value=' + data.uMoney + ' name="uMoney"id="uMoney" readonly>' +
                '<label for="uPic">上传头像</label>' +
                '<input type="file" id="uPic" name="uPic"/></div>' +
                '<div class="cbp-mc-column">' +
                '<label>性别</label>' +
                '<select id="uSex" name="uSex">' +
                '<option>男</option>' +
                '<option>女</option>' +
                '</select></div><div class="cbp-mc-submit-wrap"><input class="cbp-mc-submit" id="submit" type="button" value="Send your data"/></div></form></div></div></div>';
            $("#div").append(html);


            //鼠标在email栏失去焦点校验格式
            uEmail:$("#uEmail").blur(function () {
                checkEmail();
            });

            // 点击提交数据
            $("#submit").click(function () {
                debugger;
                update();
            });
            $("#member").click(function () {
                UpgradeMember();
            });

            $("#recharge").click(function () {
                toRecharge();
            })
        }
    });
});
//修改个人信息
var update = function () {
    debugger;
    $.ajax({
        url:"/luntan/UserController/updateUser",
        Type: "GET",
        dataType: "JSON",
        contentType:"application/json;charset=UTF-8",
        data:{
            uAccount:$("#uAccount").val(),uPassword:$("#uPassword").val(),uBirth:$("#uBirth").val(),
            uBrief:$("#uBrief").val(), uEmail:$("#uEmail").val(),uName:$("#uName").val(),
            uPic:$("#uPic").val(),uSex:$("#uSex").val()
        },
        success:function (data) {
            if (data==1){
                alert("个人信息修改成功");
            } else {
                alert("个人信息修改失败")
            }
        },
        error:function () {
            alert("服务器崩了，请稍后再试。。。")
        }
    })
};
//检查email格式
var checkEmail = function () {
    var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if (!reg.test( $("#uEmail").val())) {
        alert("email格式错误！！请输入：xxx@xx.com格式");
    }
};

//跳转到会员特权对比页面
var UpgradeMember = function () {
    location.href = "../views/member.html";
};

var removeHidden = function (data) {
    if (data.uAuthority == 2) {
        $("#crown").removeAttribute("hidden");
    }
};
//跳转到充值页面
// var  toRecharge = function () {
//     location.href = "../views/recharge.html";
// };