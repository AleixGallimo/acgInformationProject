$(function () {
    $("#btn").click(function () {
        $.ajax({
            url: "UserController/findUserById",
            success: function (data) {
                let html = "";
                $("#div").empty();
                for (var i in data) {
                    html = html.append("<div id=\"div\">\n" +
                        "    <nav class=\"navbar navbar-default\">\n" +
                        "        <div class=\"container-fluid\">\n" +
                        "            <div class=\"navbar-header\">\n" +
                        "                <a class=\"navbar-brand\" href=\"#\">\n" +
                        "                    <img alt=\"Brand\" src=\"../images/home3.gif\"\n" +
                        "                         style=\"width: 100px;height: 100px; border-radius:80%; overflow:hidden;background-color: #00b9eb\">\n" +
                        "                </a>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </nav>\n" +
                        "\n" +
                        "    <div class=\"container\">\n" +
                        "        <header class=\"clearfix\">\n" +
                        "            <h1>个人资料</h1>\n" +
                        "        </header>\n" +
                        //头像
                        "        <div id=\"pic\" style=\"text-align: center\">\n" +
                        "            <img src=${data[i].uPic} style=\"width: 200px; height:200px; border-radius:80%; overflow:hidden;\">\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <div style=\"text-align: right\">\n" +
                        "            <img src=\"../images/member.jpg\" style=\"width: 200px; height:200px; border-radius:80%; overflow:hidden;position: absolute;\n" +
                        "        right: 100px;top: 100px;>\n" +
                        "    </div>\n" +
                        "\n" +
                        "    <div class=\" main\">\n" +
                        "            <form class=\"cbp-mc-form\">\n" +
                        "                <div class=\"cbp-mc-column\">\n" +
                        "                    <label for=\"uAccount\">用户名</label>\n" +
                        "                    <input type=\"text\" value= ${data[i].uAccount id=\"uAccount\" name=\"uAccount\" placeholder=\"Jonathan\">\n" +
                        "                    <label for=\"uPassword\">密码</label>\n" +
                        "                    <input type=\"text\" value= ${data[i].uPassword id=\"uPassword\" name=\"uPassword\" placeholder=\"Password\">\n" +
                        "                    <label for=\"email\">电子邮箱</label>\n" +
                        "                    <input type=\"text\" value= ${data[i].uEmail id=\"email\" name=\"email\" placeholder=\"jon@doe.com\">\n" +
                        "                    <label for=\"uBrief\">个人简介</label>\n" +
                        "                    <textarea id=\"uBrief\"  name=\"uBrief\">${data[i].uBrief</textarea>\n" +
                        "                </div>\n" +
                        "                <div class=\"cbp-mc-column\">\n" +
                        "                    <label for=\"uName\">昵称</label>\n" +
                        "                    <input type=\"text\" value= ${data[i].uName} id=\"uName\" name=\"uName\" placeholder=\"NickName\">\n" +
                        "\n" +
                        "                    <label for=\"uMoney\">余额(￥)</label>\n" +
                        "                    <input type=\"text\" value= ${uMoney} id=\"uMoney\" name=\"uMoney\">\n" +
                        "\n" +
                        "                    <label for=\"uPic\">上传头像</label>\n" +
                        "                    <input type=\"file\" id=\"uPic\" name=\"uPic\"/>\n" +
                        "                </div>\n" +
                        "                <div class=\"cbp-mc-column\">\n" +
                        "                    <label>性别</label>\n" +
                        "                    <select id=\"uSex\" name=\"uSex\">\n" +
                        "                        <option>${data[i].uSex}</option>\n" +
                        "                        <option>${data[i].uSex}</option>\n" +
                        "                    </select>\n" +
                        "                </div>\n" +
                        "                <div class=\"cbp-mc-submit-wrap\"><input class=\"cbp-mc-submit\" type=\"submit\" value=\"Send your data\"/>\n" +
                        "                </div>\n" +
                        "            </form>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</div>")
                }

            }
        })
    })
})