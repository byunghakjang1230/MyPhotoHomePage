		
		var drop_menu_check = false;
        $('a.drop_menu_bt').on('click', function (event) {
        	event.preventDefault();

            if (drop_menu_check == false) {
            	$('#drop_menu.basic_menu').slideDown(400);
                drop_menu_check = true;
            } else {
            	$('#drop_menu.basic_menu').slideUp(400);
                drop_menu_check = false;
            }
        });
            
        $('#main_page_menu_box a').on('click', function (event) {
        	event.preventDefault();
            $('#main_page_menu').slideUp(400 , function () {
            	$('#header').animate({ opacity: 1 }, 400);
            });
        });
        
        $('#l_action').on('click', function(event){
        	event.preventDefault();
        	drop_menu_check = true;
        	var href = $(this).attr('href');
        	if(href != '#'){
        		$('#drop_menu.basic_menu').slideDown(400, function(){
            		location.href = href;
            	});         
        	}
        });
        
        $('#tl_action').on('click', function(event){
        	event.preventDefault();
        	var href = $(this).attr('href');
        	if(href != '#'){
        		$('#main_page_menu').slideUp(400, function(){
        			location.href = href;
            	});            
        	}
        });
        
        setInterval(function () {
            $('body #viewer div.nav-previous').click();
        }, 10*1000);
        
        