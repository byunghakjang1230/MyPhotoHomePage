$('#main a').on('click', function(event){
	event.preventDefault();
	var href = $(this).attr('href');
	$('body').animate({ opacity: 0 }, 300, function () {
        window.location.href = href;
    });
});