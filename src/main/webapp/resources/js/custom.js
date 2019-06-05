//INICIALIZACAO DO MENU E FECHAMENTO DO MODAL LOADING, APOS O CARREGAMENTO DO DOCUMENTO
$(document).ready(function () {
    init();
});

var init = function () {

    $('.sidebar-open').on("click", function () {
        if ($('.sidebar').hasClass('fadeInMenu')) {
            $('.sidebar').removeClass('fadeInMenu');
            $('.main-content').removeClass('main-content-sidebar-open');
            $('footer').removeClass('footer-sidebar-open');
        } else {
            $('.sidebar').addClass('fadeInMenu');
            $('.main-content').addClass('main-content-sidebar-open');
            $('footer').addClass('footer-sidebar-open');
        }
    });

    $('.sidebar-menu > li.have-children > a').on('click', function (i) {
        i.preventDefault();
        if (!$(this).parent().hasClass('active')) {
            $('.sidebar-menu li ul').slideUp();
            $(this).next().slideToggle();
            $('.sidebar-menu li').removeClass('active');
            $(this).parent().addClass('active');
        } else {
            $(this).next().slideToggle();
            $('.sidebar-menu li').removeClass('active');
        }
    });

    redimensionar();
};
