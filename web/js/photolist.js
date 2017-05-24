$(document).ready(function() {
	$('#PhotoTableContainer').jtable({
		title : 'Photo List',
		actions : {
			listAction : 'photo_list'
		},

		fields : {
			idPhoto : {
				title : 'Id',
				width : '5%',
				key : true,
				list : true,
				edit : false,
				create : true
			},
			titolo: {
				title : 'Titolo',
				width : '20%',
				edit : true
			},
			nome : {
				title : 'Nome',
				width : '20%',
				edit : true
			},
			cognome : {
				title : 'Cognome',
				width : '20%',
				edit : true
			},


            monumento : {
                title : 'Monumento',
                width : '10%',
                edit : true
            },

            stato : {
                title : 'Status',
                width : '20%',
                edit : true
            }



		}
	});
	$('#PhotoTableContainer').jtable('load');
});