/**
 * Created by Addolorata on 24/05/2017.
 */

$(document).ready(function() {
    $('#MonumentTableContainer').jtable({
        title : 'Monuments List',
        actions : {
            listAction : 'monument_list',
            createAction : 'monument_create',
            deleteAction : 'monument_delete',
            updateAction:'monument_update'
        },

        fields : {
            idMonument : {
                title : 'IdMonument',
                width : '0%',
                key : true,
                list : false,
                edit : false,
                create : false
            },
            monument : {
                title : 'Monument',
                width : '20%',
                list : true,
                edit : true,
                create : true
            },
            progress : {
                title : 'Progress',
                width : '10%',
                list : true,
                edit : true,
                create : true
            }



        }
    });
    $('#MonumentTableContainer').jtable('load');
});
