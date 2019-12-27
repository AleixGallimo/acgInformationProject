

//判断用户的权限
var userRight = function () {
    $.ajax({
        url:"/acgInformation/UserRightController/isVIP",
        Type: "GET",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        success:function (data) {
            if (data==2){
            	debugger;
                alert("您已经是超级VIP了哦，无需再购买了！！")
            }
            if (data==1){
                location.href = "../views/updateMember.html"
            }
            if (data==3){
                alert("欢迎您，管理员主人，无需购买了，请尽情享用吧！！")
            }
            if (data==0){
                alert("你已经被禁言！！反省后再来！！")
            }
        }
    })
};

//返回个人信息页面
var userPage = function () {
	if (data==2) {
		location.href="../views/finduser.html";
	}
};
//支付功能
var pay=function (password1) {
	console.log(password1);
	debugger;
    $.ajax({
        url:"/acgInformation/UserRightController/BuyVIP",
        Type: "GET",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        data: {password1 :password1},
        success:function (data) {
            if (data==0){
                alert("您的余额不足，请先充值。")
            }
            if (data==1){
                alert("充值成功！，您已经是超级会员啦！");
                location.href = "/acgInformation/views/finduser.html";

            }
            if (data == 2) {
                alert("支付密码和登录密码不一致！")
            }
        }
    })
};

$(function () {

    // $(function(){
        	//出现浮动层
        	$(".ljzf_but").click(function(){
        		$(".ftc_wzsf").show();
        	});
        	//关闭浮动
        	$(".close").click(function(){
        		$(".ftc_wzsf").hide();
        		$(".mm_box li").removeClass("mmdd");
        		$(".mm_box li").attr("data","");
        		i = 0;
        	});
        		//数字显示隐藏
        	$(".xiaq_tb").click(function(){
        		$(".numb_box").slideUp(500);
        	});
        	$(".mm_box").click(function(){
        		$(".numb_box").slideDown(500);
        	});
        		//----
        	var i = 0;
        	$(".nub_ggg li .zf_num").click(function(){

        		if(i<6){
        			$(".mm_box li").eq(i).addClass("mmdd");
        			$(".mm_box li").eq(i).attr("data",$(this).text());
        			i++
        			if (i==6) {
        			  setTimeout(function(){
        				var password1 = "";
        					$(".mm_box li").each(function(){
        					password1 += $(this).attr("data");
        				});
        					pay(password1);
						  $(".ftc_wzsf").hide();

        				// alert("支付成功"+data);
        			  },100);
        			};
        		}
        	});

        	$(".nub_ggg li .zf_del").click(function(){
        		if(i>0){
        			i--
        			$(".mm_box li").eq(i).removeClass("mmdd");
        			$(".mm_box li").eq(i).attr("data","");
        		}
        	});

        	$(".nub_ggg li .zf_empty").click(function(){
        		$(".mm_box li").removeClass("mmdd");
        		$(".mm_box li").attr("data","");
        		i = 0;
        	});

        // });

    $("#UpgradeMember").click(function () {
        userRight();
    })
});