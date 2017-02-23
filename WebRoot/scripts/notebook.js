function loadNoteBooks(){//页面载入后自动发请求，加载笔记本列表
    		$.ajax({
    			url:"http://localhost:8080/cloud_note/notebook/loadbooks.do",
    			type:"post",
    			data:{"userId":userId},
    			dataType:"json",
    			success:function(result){
    				if(result.status==0){
    					var books = result.data;//笔记本json集合
    					//循环集合，生成笔记本li列表
    					for(var i=0;i<books.length;i++){
    						var bookName = books[i].cn_notebook_name;
    						//获取每个比基本元素的笔记本Id
    						var bookId = books[i].cn_notebook_id;
    						//拼成li元素
    						var s_li = '<li class="online"><a>';
    						s_li += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
							s_li +=	'</i>'+bookName+'</a></li>';
							//将s_li字符串转成jQuery对象，藏bookId
							var $li = $(s_li);//绑定bookId值
							$li.data("bookId",bookId);
							//将li添加到笔记本ul中
							$("#book_list").append($li);
    					}
    				}
    			}
    		});
    		
   }