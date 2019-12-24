var update = {
    // data: {uAccount:$("#uAccount").val(),uPassword:$("#uPassword").val(),
    //     uBrief:$("#uBrief").val(), email:$("#email").val(),uName:("#uName").val(),
    //     uMoney:$("#uMoney").val(),uPic:("#uPic").val(),uSex:("#uSex").val()},
    methods: {
        getUser: function () {
            $.ajax({
                url: "/luntan/UserController/findUserById",
                Type: "GET",
                dataType: "JSON",
                async: false,
                contentType: "application/json;charset=UTF-8",
                data: {},
                success: function (data) {

                    data.
                    $("#div").empty();
                    var html = '<div id="div">' +
                        '<nav class="navbar navbar-default">' +
                        '<div class="container-fluid">' +
                        '<div class="navbar-header">' +
                        '<a class="navbar-brand" href="#">' +
                        '<img alt="Brand" src="../images/home3.gif"' +
                        'style="width: 100px;height: 100px; border-radius:80%; overflow:hidden;background-color: #00b9eb">' +
                        '</a>' +
                        '</div></div></nav><div class="container"><header class="clearfix"><h1>个人资料</h1></header>' +
                        <!--        头像-->
                        '<div id="pic" style="text-align: center"><img src="../images/Icon.jpg" style="width: 200px; height:200px; border-radius:80%; overflow:hidden;"></div>' +
                        '<div style="text-align: right"><img src="../images/member.jpg" style="width: 200px; height:200px; border-radius:80%; overflow:hidden;position: absolute;right: 100px;top: 100px;></div>' +
                        '<div class="><form class="cbp-mc-form"><div class="cbp-mc-column"><label for="uAccount">用户名</label>' +
                        '<input type="text" value=' + data.uAccount + ' name="uAccount"id="uAccount">' +
                        '<label for="uPassword">密码</label>' +
                        '<input type="text" value=' + data.uPassword + ' name="uPassword"id="uPassword">' +
                        '<label for="email">电子邮箱</label>' +
                        '<input type="text" value=' + data.uEmail + ' name="email"id="email">' +
                        '<label for="uBrief">个人简介</label>' +
                        '<textarea id="uBrief" name="uBrief">' + data.uBrief + '</textarea></div>' +
                        '<div class="cbp-mc-column"><label for="uName">昵称</label>' +
                        '<input type="text"value=' + data.uName + '" name="uname"id="uName">' +
                        '<label for="uMoney">余额(￥)</label>' +
                        '<input type="text" value=' + data.uMoney + ' name="uMoney"id="uMoney" readonly>' +
                        '<label for="uPic">上传头像</label>' +
                        '<input type="file" id="uPic" name="uPic"/></div>' +
                        '<div class="cbp-mc-column">' +
                        '<label>性别</label>' +
                        '<select id="uSex" name="uSex">' +
                        '<option>MAN</option>' +
                        '<option>WOMEN</option>' +
                        '</select></div><div class="cbp-mc-submit-wrap"><input class="cbp-mc-submit" id="submit" type="button" value="Send your data"/></div></form></div></div></div>';
                    $("#div").append(html);

                }
            });
        },

        updateUser:function () {
            // $("#submit").click(function () {
                debugger;
                $.ajax({
                    url: "/luntan/UserController/updateUser",
                    Type: "POST",
                    dataType: "JSON",
                    contentType: "application/json;charset=UTF-8",
                    data: {
                        uAccount:$("#uAccount").val(),uPassword:$("#uPassword").val(),
                            uBrief:$("#uBrief").val(), email:$("#email").val(),uName:("#uName").val(),
                            uMoney:$("#uMoney").val(),uPic:("#uPic").val(),uSex:("#uSex").val()
                    },
                    success: function (data) {
                        alert(data.uAccount);
                    }
                })
            // });
        }
    }
};

$(function () {
    update.methods.getUser();
});

$("#submit").click(function () {
    debugger;
    update.methods.updateUser();
});

