$(document).ready(function() {
    $('#PhotoCheckedTableContainer').jtable({
        title : 'Cheched Photo List',
        selecting: true, //Enable selecting
        multiselect: false, //Allow multiple selecting
        selectingCheckboxes: false, //Show checkboxes on first column
        //selectOnRowClick: false, //Enable this to only select using checkboxes
        openChildAsAccordion: true, //Enable this line to show child tabes as accordion style
        actions : {
            listAction : 'photo_checked_list'
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
            }
        }
    });
    $('#PhotoCheckedTableContainer').jtable('load');
});/**
 * Created by Enifix on 26/05/2017.
 */
