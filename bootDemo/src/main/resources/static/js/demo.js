$(function () {
    //计算内容区域高度
    $(".float_nav").height($(window).height() - 71);
    $('div.tab-content').height($(window).height() - 121);

    //菜单点击
    $('a', $('#accordion')).on('click', function (e) {
        e.stopPropagation();
        var a = $(this).closest('a');
        var menuId = $(a).attr('mid');
        var url = $(a).attr('funurl');
        var title = $(this).text();
        $('#mainFrameTabs').bTabsAdd(menuId, title, url);


        //计算Tab可用区域高度

    });

    //初始化
    $('#mainFrameTabs').bTabs();
});


$(function () {
    var Accordion = function (el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;

        // Variables privadas
        var links = this.el.find('.one');
        // Evento
        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)


    }


    Accordion.prototype.dropdown = function (e) {
        var $el = e.data.el;
        $this = $(this).parent(".link"),
            $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        $(".one").css("color", "#333");
        $(this).css("color", "#1ca2ff");


        if (!e.data.multiple) {
            $el.find('.submenu').not($next).slideUp().parent().removeClass('open');

        }
        ;
    }

    var accordion = new Accordion($('#accordion'), false);


    $(".submenu a").click(function () {

        $(".submenu a").removeClass("active");
        $(this).addClass("active");
    })


});