$(document).ready(function() {
	$('#StudentTableContainer').jtable({
		title : 'User List',
		actions : {
			listAction : 'people_list',
            createAction : '',
			updateAction:'people_update',
			deleteAction:'people_delete'
		},

		fields : {
			idUser : {
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
                edit : false
			},
			cognome : {
				title : 'Cognome',
				width : '20%',
                edit : false
			},
			email : {
				title : 'Email',
				width : '10%',
				edit : true
			},

            point : {
                title : 'Punti',
                width : '10%',
                edit : true
            },

            login_type : {
                title : 'Tipo di accesso',
                width : '10%%',
                edit : false
            }



		}
	});
	$('#StudentTableContainer').jtable('load');
});