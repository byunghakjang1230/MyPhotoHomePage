/*
        var checkUnload = false;

        $(window).on("beforeunload", function () {
            if (checkUnload)
                return "진짜?";
        });
        */

        var result_tample = Handlebars.compile($('#result_tample').html());
        var subcate_tample = Handlebars.compile($('#subcate_tample').html());
        
        var num_list_tample = Handlebars.compile($('#num_list_tample').html());


        var change_switch = false;
        var before_num = 0;
        var after_num = 0;

        ////////////////////////////////////////////////
        ////리스트에 번호 붙이기.(초기화)			////
        var setLiClassNum = function () {
            $('#result_ > ul > li').removeClass();
            $('#num_list > li').removeClass();

            var count = $('#result_ > ul > li').length;

            for (var i = 0; i < count; i++) {
                $('#result_ > ul > li:nth-child(' + (i + 1) + ')').attr('class', i);
                $('#num_list > li:nth-child(' + (i + 1) + ')').attr('class', i);
            }
        }

        //////////////////////////////////////////////
        //		파일 submit때 수행될 함수. 			//
        //		        	수정	                   	//
        var getFileValues = function (count) {
            var photo_info = [];
            var maincate = $('#maincate').val();
            var subcate = $('#subcate').val();
            for (var i = 0; i < count; i++) {
                var a_no = $('#result_ > ul > li.' + i + ' #c_no').val();
                var b_no = $('#num_list > li.' + i + ' > input').val();
                var ch_m = $('#result_ > ul > li.' + i + ' #m_ch').val();
                
                if (a_no != b_no)
                    ch_m = 'c';

                var photo = {
                    'maincate': maincate,
                    'subcate': subcate,
                    'no': b_no,
                    'title': $('#result_ > ul > li.' + i + ' #title').val(),
                    'context': $('#result_ > ul > li.' + i + ' #context').val(),
                    'filename': $('#result_ > ul > li.' + i + ' #filename').val(),
                    'thumbname': $('#result_ > ul > li.' + i + ' #thumbname').val(),
                    'change': ch_m
                }
                photo_info.push(photo);
            }
            return photo_info;
        }

        //////////////////////////////////////////////////////////////
        //					수정내용 저장								//

        $('#send_bt').on('click', function (event) {
            event.preventDefault();
            var count = $('#result_ > ul > li').length;
            if (count > 0) {
                $.ajax({
                    url: '/ir/mod',
                    type: 'put',
                    dataType: 'text',
                    headers: {
                        'Content-Type': 'application/json',
                        'X-HTTP-Method-Override' : 'PUT'
                    },
                    data: JSON.stringify(getFileValues(count)),
                    success: function (result) {
                        alert('등록되었습니다.')
                        $('#result_ > ul').empty();
                        $('#num_list').empty();
                        $('#maincate').val('n');
                        $('#subcate').empty().append(subcate_tample());
                    },
                    statusCode: {
                        400: function () {
                            alert('등록에 실패했습니다.\n다시 시도해주세요.');
                        },
                    	401 : function(){
                    		alert('권한이 없습니다.');
                        	$('#loading').removeClass('load_proc');
                            $('body').removeClass('load_proc');
                    	}
                    }
                });
            }
        });

        
        $('#result_').on('click', '#change', function () {
            var empty = $(this).parent().parent().parent().attr('class');
            var min_no, max_no = 0;
            if (change_switch == false) {
                before_num = empty;
                $(this).addClass('selected');
                change_switch = true;
            } else {
                after_num = empty;
                if (after_num < before_num) {
                    $('#result_ li.' + after_num).before($('#result_ li.' + before_num));
                } else if (after_num > before_num) {
                    $('#result_ li.' + after_num).after($('#result_ li.' + before_num));
                }
                
                $('#change.selected').removeClass('selected');
                setLiClassNum();
                change_switch = false;
            }
        });
        
        /************************  메인 카테고리 변경 ****************************/
        $('#maincate').on('change', function () {
            var maincate = $(this).val();
            if(maincate != 'n'){
            	$.getJSON('/ir/ct/' + maincate, function (data) {
                    $('#subcate').empty().append(subcate_tample(data));
            	});
            }            
        });
        
        /************************  서브 카테고리 변경 ****************************/
        $('#subcate').on('change', function () {
        	var maincate = $('#maincate').val();
            var subcate = $(this).val();
            if(subcate != 'n'){
            	$.getJSON('/ir/ct/' + maincate+'/'+subcate, function (data) {
                        $('#result_ > ul').empty().append(result_tample(data));
                        $('#num_list').empty().append(num_list_tample(data));
                        setLiClassNum();
                });
            }
        });
        
        /***************** 새로 추가 ***********************/
        $('#result_').on('change', '#title, #context', function () {
            $(this).parent().parent().parent().parent().parent().find('#m_ch').val('c');
        });

        /***************** 새로 추가 ***********************/

        $('*').on('dragenter dragover drop', function (event) {
            event.preventDefault();
        });

        /***************** 수정 ************************/
        $('#result_').on('click', '#del', function (event) {
            event.preventDefault();
            var con = confirm('삭제하시겠습니까?');
            if (con == true) {
            	$('#loading').addClass('load_proc');
            	$('body').addClass('load_proc');
                var c_no = $(this).parent().parent().find('#c_no').val();

                var del_li = $(this).parent().parent().parent();
                var del_no_li = $('#num_list input.' + c_no).parent();
                
                $.ajax({
                    url: '/ir/del/' + c_no,
                    type: 'delete',
                    dataType: 'text',
                    headers: {
                        'Content-Type': 'application/json',
                        'X-HTTP-Method-Override' : 'DELETE'
                    },
                    success: function (result) {
                        del_li.remove();
                        del_no_li.remove();
                        setLiClassNum();
                        alert('데이터를 삭제했습니다.');
                        $('#loading').removeClass('load_proc');
                    	$('body').removeClass('load_proc');
                    },
                    statusCode: {
                        400: function () {
                            alert('데이터 처리중입니다.\n잠시뒤 시도해 주세요.');
                            $('#loading').removeClass('load_proc');
                        	$('body').removeClass('load_proc');
                        },
                    	401 : function(){
                    		alert('권한이 없습니다.');
                        	$('#loading').removeClass('load_proc');
                            $('body').removeClass('load_proc');
                    	}
                    }
                });
            }            
        });
        
        