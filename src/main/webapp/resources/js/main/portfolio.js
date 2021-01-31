
            $('#menu_ a').on('mouseenter', function (event) {
                event.preventDefault();
                $(this).addClass('overed');
            });

            $('#menu_ a').on('mouseleave', function (event) {
                event.preventDefault();
                $(this).removeClass('overed');
            });

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