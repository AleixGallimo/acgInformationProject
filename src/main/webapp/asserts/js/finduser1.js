//检查
/*uAccount:$("#uAccount").val(),uPassword:$("#uPassword").val(),uBirth:$("#uBirth").val(),
            uBrief:$("#uBrief").val(), uEmail:$("#uEmail").val(),uName:$("#uName").val(),
            uPic:$("#head").val(),uSex:$("#uSex").val()

            placeholder="Email"

            */

//
$(function () {
    $.ajax({
        url: "/acgInformation/UserController/findUserById",
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
                //首页的入口
                '<a href="/acgInformation/index.html" >'+
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
                '<div id="pic" style="text-align: center">' +
                '<input id="upload" name="file" accept="image/*" type="file" style="display: none">' +
                '<img id="head" src="../' + data.uPic + '" alt="头像" style="width: 200px; height:200px; border-radius:80%; overflow:hidden;>' +
                '</div>' +
                '<div style="text-align: right"><img src="../asserts/images/member.jpg" id="member" alt="升级会员入口" style="width: 200px; height:200px; border-radius:80%; overflow:hidden;position: absolute;right: 100px;top: 100px;></div>' +
                '<div class="><form  class="cbp-mc-form" enctype="multipart/form-data"><div class="cbp-mc-column"><label for="uAccount">用户名</label>' +
                '<input type="text"  name="uAccount"id="uAccount" value=' + data.uAccount + ' readonly>' +
                '<label for="uPassword">密码</label>' +
                '<input type="text" name="uPassword"id="uPassword" value=' + data.uPassword + ' >' +
                '<label for="uEmail">电子邮箱</label>' +
                '<input type="text" name="uEmail" id="uEmail" value=' + data.uEmail +'>' +
                '<label for="uBrief">个人简介</label>' +
                '<textarea id="uBrief" name="uBrief">' + data.uBrief + '</textarea></div>' +
                '<div class="cbp-mc-column"><label for="uName">昵称</label>' +
                '<input type="text" name="uName"id="uName"value=' + data.uName+'>' +

                '<label for="uBirth">生日</label>' +
                '<input type="text" name="uBirth"id="uBirth"value=' + data.uBirth+'>' +

                '<label for="uMoney">余额(￥)</label>' +
                '<input type="text" value=' + data.uMoney + ' name="uMoney"id="uMoney" readonly>' +
                // '<label for="uPic">上传头像</label>' +
                // '<input type="file" id="uPic" name="uPic" />' +
                //上传按钮
               /* '<input type="button" value="上传" id="upimg" name="upimg"/>'+'</div>' +*/
                '<div class="cbp-mc-column" style="width: 310px">' +
                '<label>性别</label>' +
                // '<select id="uSex" name="uSex">' +
                // '<option>男</option>' +
                // '<option>女</option>' + '</select>' +
                '<input type="text"  name="uSex" id="uSex" value='+data.uSex+'>'+
                '</div><div class="cbp-mc-submit-wrap"><input class="cbp-mc-submit" id="submit" type="button" value="Send your data"/></div></form></div></div></div>';
            $("#div").append(html);
            $("input").each(function () {
                if($(this).val() == 'undefined' || $(this).val() == "" ||  $(this).val() == null){
                    $(this).val("");
                    $(this).attr("placeholder", "请更改资料..");
                }
            })
            if($("#uBrief").val() == 'undefined' || $("#uBrief").val() == "" ||  $("#uBrief").val() == null){
                $("#uBrief").text("请输入个人简介..");

            }




            //点击上传头像
            $("#upimg").click(function () {
               upimg();
            });

            //上传头像

                $("#head").click(function() {
                    $("#upload").click(); //隐藏了input:file样式后，点击头像就可以本地上传
                    $("#upload").on("change", function() {
                        var objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
                        if (objUrl) {
                            $("#head").attr("src", objUrl); //将图片路径存入src中，显示出图片
                            upimg();
                        }
                    });
                });


//建立一?可存取到?file的url
            function getObjectURL(file) {
                var url = null;
                if (window.createObjectURL != undefined) { // basic
                    url = window.createObjectURL(file);
                } else if (window.URL != undefined) { // mozilla(firefox)
                    url = window.URL.createObjectURL(file);
                } else if (window.webkitURL != undefined) { // webkit or chrome
                    url = window.webkitURL.createObjectURL(file);
                }
                return url;
            }
//上传头像到服务器
            function upimg() {
                console.log(344);
                var pic = $('#upload')[0].files[0];
                var file = new FormData();
                file.append('fileName', pic);
                $.ajax({
                    url: "/acgInformation/UserController/fileDownLoad",
                    contentType:"html/text;charset=UTF-8",
                    type: "POST",
                    data: file,
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function(data) {
                        console.log(data);
                        var res = data;
                        $("#head").append("<img src='/" + res + "'>")
                    }
                });
            }



            // 点击提交数据
            $("#submit").click(function () {
                debugger;
                if ($("#uAccount").val()=="" || $("#uPassword").val()==""){
                    console.log("#uAccount\").val()"+$("#uAccount").val());
                    alert("用户名或密码不能为空")
                } else if ($("#uAccount").val()=="" && $("#uPassword").val()=="") {
                    alert("密码不能为空")
                }else if (!/^\d{6}$/.test($("#uPassword").val())) {
                    alert("密码要6位数字啊啊啊啊啊啊")
                }else if (!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test( $("#uEmail").val())&& $("#uEmail").val()!="") {
                    alert("email格式错误！！请输入：xxx@xx.com格式");
                }else {
                    update();
                }
            });

            //鼠标在email栏失去焦点校验格式
            uEmail:$("#uEmail").blur(function () {
                checkEmail();
            });

            $("#member").click(function () {
                UpgradeMember();
            });

            $("#recharge").click(function () {
                toRecharge();
            });


        }
    });
});



//修改个人信息
var update = function () {
    debugger;
    $.ajax({
        url:"/acgInformation/UserController/updateUser",
        Type: "GET",
        dataType: "JSON",
        contentType:"application/json;charset=UTF-8",
        data:{
            uAccount:$("#uAccount").val(),uPassword:$("#uPassword").val(),uBirth:$("#uBirth").val(),
            uBrief:$("#uBrief").val(), uEmail:$("#uEmail").val(),uName:$("#uName").val(),
            uPic:$("#head").val(),uSex:$("#uSex").val()
        },
        success:function (data) {
            if (data==1){
                alert("个人信息修改成功");
            } else if (data == -1) {
                alert("用户名或密码不能为空");
            }else {
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



