$(document).ready(function() {
	$('#StudentTableContainer').jtable({
		title : 'Students List',
		actions : {
			listAction : 'people_list'
		},

		fields : {
			iduser : {
				title : 'Id User',
				width : '5%',
				key : true,
				list : true,
				edit : false,
				create : true
			},
			nome : {
				title : 'Name',
				width : '20%',
				edit : true
			},
			cognome : {
				title : 'Cognome',
				width : '20%',
				edit : true
			},
			email : {
				title : 'Email',
				width : '20%',
				edit : true
			},


            point : {
                title : 'Punti',
                width : '10%',
                edit : true
            },

            login_type : {
                title : 'Tipo di accesso',
                width : '20%',
                edit : true
            }



		}
	});
	$('#StudentTableContainer').jtable('load');
});