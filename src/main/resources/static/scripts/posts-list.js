(function () {
    var request = $.ajax({
        url: "/posts.json"});

    request.done(function (posts) {
        console.log(posts);
        var i, html='';
        for (i = 0; i<posts.length; i++){
            html+='<div><h2>' + posts[i].title + '</h2><p>' + posts[i].body+ '</p>'
            + '<img src="/uploads/' + posts[i].image + '" alt= "No image" /></div>';
        }
        $('#load-posts').html(html);
    })
})();