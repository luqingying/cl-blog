new Vue({
    el: '.small-nav',
    data: {
        isShow: false
    }
});

new Vue({
    el: '.pull-down',
    data: {
        isShow: false
    },
    methods: {
        onEnter: function (isShow) {
            isShow = !isShow;
            return isShow;
        },
        onOut: function (isShow) {
            isShow = !isShow;
            return isShow;
        }
    }
});

/**
 * Created by luqingying on 2019/1/23.
 */
