 <%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpSession" %>


 <% String xdoc =request.getParameter("trxdocs")==null?"0":request.getParameter("trxdocs").toString();
 System.out.println("=====xdoc==getAttribute===="+request.getAttribute("trxdocs"));
 System.out.println("=====xdoc===getParameter==="+request.getParameter("trxdocs"));%>

 <script type="text/javascript">
 
 var data;
  
 //alert("sdfghjkjhgfdsadfghjhgfds"+$('#docs').val());
   data='<%= com.SATdownload.SATdownloadDAO.loadTrafficData(xdoc) %>'; 
    
    //alert("==================loadTrafficData");
        $(document).ready(function () { 	
            
             var num = 0; 
            var source =
            {
            		
    //tcno,ticket_no,traffic_date,time,fine_source,amount,regno,Pcolor,licence_no,licence_from,tick_violat,tick_location
            		
                datatype: "json",
                datafields: [
							{name : 'tcno', type: 'String'  },
     						{name : 'ticket_no', type: 'String'  },
     						{name : 'traffic_date', type: 'String' },
     						{name : 'time', type: 'String' },
     						{name : 'fine_source', type: 'String' },
     						{name : 'amount', type: 'String' },
     						{name : 'regno', type: 'String' },
     						{name : 'pcolor', type: 'String' },
     						{name : 'licence_no', type: 'String' },
     						{name : 'licence_from', type: 'String' },
     						{name : 'tick_location', type: 'String' },
     						{name : 'tick_violat', type: 'String' }
                 ],
                 localdata: data,
                
                
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
            $("#jqxloadtrafficdataGrid").jqxGrid(
            {
                width: '100%',
                height: 200,
                source: dataAdapter,
                columnsresize: true,
                //pageable: true,
                altRows: true,
                sortable: true,
                selectionmode: 'singlerow',
                showfilterrow: true,
                filterable: true,
                //pagermode: 'default',
                sortable: true,
                //Add row method
                columns: [
					{ text: '#TcNo',columntype: 'textbox', filtertype: 'input', datafield: 'tcno', width: '10%' },
					{ text: 'Fine No',columntype: 'textbox', filtertype: 'input', datafield: 'ticket_no', width: '10%' },
					{ text: 'Traffic Date',columntype: 'textbox', filtertype: 'input', datafield: 'traffic_date', width: '10%' },
					{ text: 'Time',columntype: 'textbox', filtertype: 'input', datafield: 'time', width: '10%' },
					{ text: 'Fine Source',columntype: 'textbox', filtertype: 'input', datafield: 'fine_source', width: '10%' },
					{ text: 'Fees',columntype: 'textbox', filtertype: 'input', datafield: 'amount', width: '10%' },
					{ text: 'Plate No',columntype: 'textbox', filtertype: 'input', datafield: 'regno', width: '10%' },
					{ text: 'Plate Category',columntype: 'textbox', filtertype: 'input', datafield: 'pcolor', width: '10%' },
					/* { text: 'Plate Code',columntype: 'textbox', filtertype: 'input', datafield: 'pcolor', width: '10%' }, */
					{ text: 'Licence No',columntype: 'textbox', filtertype: 'input', datafield: 'licence_no', width: '10%' },
					{ text: 'Licence From',columntype: 'textbox', filtertype: 'input', datafield: 'licence_from', width: '10%' },
					/* { text: 'Ticket Violation Desc',columntype: 'textbox', filtertype: 'input', datafield: 'TICK_VIOLAT', width: '10%' }, */
					{ text: 'Ticket Location',columntype: 'textbox', filtertype: 'input', datafield: 'tick_location', width: '10%' },
					{ text: 'Reason For Not Paying',columntype: 'textbox', filtertype: 'input', datafield: 'tick_violat', width: '10%' }
					
	              ]
            });

           
        });
    </script>
    <div id="jqxloadtrafficdataGrid"></div>
