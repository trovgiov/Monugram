$(document).ready(function() {
	$('#PhotoTableContainer').jtable({
		title : 'Photo List',
        selecting: true, //Enable selecting
        multiselect: false, //Allow multiple selecting
        selectingCheckboxes: false, //Show checkboxes on first column
        //selectOnRowClick: false, //Enable this to only select using checkboxes
        openChildAsAccordion: true, //Enable this line to show child tabes as accordion style
		actions : {
			listAction : 'photo_list'
		},

		fields : {
			idPhoto : {
                title: 'Id',
                width: '5%',
                key: true,
                list: true,
                edit: false,
                create: true
            },


			titolo: {
				title : 'Titolo',
				width : '20%',
				edit : true
			},
			nome : {
				title : 'Nome',
				width : '10%',
				edit : true
			},
			cognome : {
				title : 'Cognome',
				width : '10%',
				edit : true
			},


            monumento : {
                title : 'Monumento',
                width : '20%',
                edit : true
            },

            stato : {
                title: 'Status',
                width: '10%',
                edit: true
            },
            settings : {
                title : 'settings',
                width : '20%',
                edit : true,
                display: function (photomanage) {
                    //Create an image that will be used to open child table
                    var $img = $('<img src="/css/settings.png" title="Edit Chips" />');
                    //Open child table when user clicks the image
                    $img.click(function () {
                        //window.location.href = "/Monugram/facebook_login.action?nome=" + response.first_name + "&cognome=" + response.last_name + "&email=" + response.email;

                        window.location.href = "/Monugram/photo_manage.action?idPhoto="+photomanage.record.idPhoto;

                    });
                    //Return image to show on the person row
                    return $img;
                }
            }
            }



	});
	$('#PhotoTableContainer').jtable('load');
});