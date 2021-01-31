var menu_switch = false;
var firstUpper = function (str) {
    return str.substr(0, 1).toUpperCase() + str.substr(1);
}

$('a.drop_menu_bt').on('click', function (event) {
	event.preventDefault();
    if (menu_switch == false) {
    	$('#drop_menu').slideDown(300);
        menu_switch = true;
    }else{
    	$('#drop_menu').slideUp(300);
        menu_switch = false;
    }
});

$('div.toggle').on('click', function () {
	$('#drop_menu').delay(500).slideUp(0);
    menu_switch = false;
});


$('#main_cate_').text(firstUpper($('#main_cate_').text()));
$('#sub_cate_').text(firstUpper($('#sub_cate_').text()));