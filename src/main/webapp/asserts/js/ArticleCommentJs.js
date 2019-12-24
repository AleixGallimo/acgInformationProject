//获取文章方法
var getArticle = function () {
    $.ajax({
        url:"/acgInformation/article/getArticleById",
        data:{
            id:articleId
        },
        async:false,
        success:function (data) {
            var article = JSON.parse(data);
            console.log(article);
            author = article.aAuthor;
            $(".catalog").text("首页 > " +  article.aType);
            $(".title").text(article.title);
            $(".time").text(article.aDate);
            $(".read").text(article.aRead);
            $(".like").text(article.aLike);
            $(".contentImg").attr("src",article.aPic);
            $(".articleP").text(article.aText);
        }
    })
}