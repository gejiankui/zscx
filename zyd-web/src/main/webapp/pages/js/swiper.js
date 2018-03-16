
window.onload = function(){
    var newSlideSize = function slideSize(){
        var w = Math.ceil($(".swiper-container").width()*(540/1242)/*--调整高度---*/);
        $(".swiper-container,.swiper-wrapper,.swiper-slide").height(w);
    };
    newSlideSize();
    $(window).resize(function(){
        newSlideSize();
    });

    var mySwiper = new Swiper('.swiper-container',{
        pagination: '.pagination',
        loop:false,
        autoplay:3000,
        paginationClickable: false,
        onSlideChangeStart: function(){
            //回调函数
        },
		onTouchEnd: function(a){
			a.startAutoplay();
		}
    });
    // cTab("#tab1","#con1");
    // cTab("#tab2","#con2");


};