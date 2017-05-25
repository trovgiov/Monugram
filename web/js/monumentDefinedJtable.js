/**
 * Created by Addolorata on 24/05/2017.
 */

$(document).ready(function() {
    $('#MonumentTableContainer').jtable({
        title : 'Monuments List',
        actions : {
            listAction : 'monuments_list',
            createAction : 'monuments_create.action',
            deleteAction : 'monuments_delete.action',
            updateAction:'monuments_update.action'
        },

        fields : {
            idMonument : {
                title : 'IdMonument',
                width : '5%',
                key : true,
                list : true,
                edit : false,
                create : true
            },
            monument : {
                title : 'Monument',
                width : '20%',
                key : true,
                list : true,
                edit : true,
                create : true
            },
            progress : {
                title : 'Progress',
                width : '20%',
                key : true,
                list : true,
                edit : true,
                create : true
            }



        }
    });
    $('#MonumentTableContainer').jtable('load');
});
