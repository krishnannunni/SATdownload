<%--    <jsp:include page="../../includes.jsp"></jsp:include> --%> 
 
 <script type="text/javascript">
    var datauser= '<%= com.SATdownload.SATdownloadDAO.sat_unamesearch() %>';
    //alert("===========sat_unamesearch=======data");
        $(document).ready(function () { 	
            
             var num = 0; 
            var source =
            {
                datatype: "json",
                datafields: [
     						{name : 'username', type: 'String'  }
                 ],
                 localdata: datauser,
                
                
                pager: function (pagenum, pagesize, oldpagenum) {
                    // callback called when a page or page size is changed.
                }
            };
            
            var dataAdapter = new $.jqx.dataAdapter(source,
            		 {
                		loadError: function (xhr, status, error) {
	                    alert(error);    
	                    }
		            }		
            );
            $("#jqxUsernameGrid").jqxGrid(
            {
            	 width: '95%',
                 height: 300,
                 source: dataAdapter,
                 editable: true,
                 selectionmode: 'singlecell',
                columns: [
					{  text: 'Sr. No.', sortable: false, filterable: false, editable: false,
						   groupable: false, draggable: false, resizable: false,datafield: '',
						   columntype: 'number', width: '10%',cellsalign: 'center', align: 'center',
						   cellsrenderer: function (row, column, value) {
						   return "<center><div style='margin:4px;'>" + (value + 1) + "</div></center>";
						   }  
						},  
					
					{ text: 'User Name',columntype: 'textbox', filtertype: 'input', datafield: 'username', width: '90%' }
	              ]
            });

            $('#jqxUsernameGrid').on('rowdoubleclick', function (event) 
            		{ 
		            	var rowindex1=event.args.rowindex;
		                document.getElementById("txtusername").value= $('#jqxUsernameGrid').jqxGrid('getcellvalue', rowindex1, "username");
		              $('#unameWindow').jqxWindow('close');
            		 }); 
           
        });
    </script>
    <div id="jqxUsernameGrid"></div>
