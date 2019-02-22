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

new Vue({
    el: '.webpage-footer',
    data (){
        return {
            fullHeight: document.documentElement.clientHeight,
            height : document.body.scrollHeight
        }
    },
    mounted() {
        const that = this
        window.onresize = () => {
            return (() => {
                window.fullHeight = document.documentElement.clientHeight
                that.fullHeight = window.fullHeight
                that.height = document.body.scrollHeight
            })()
        }
    },
    watch: {
        fullHeight (fval) {
            if(!this.timer) {
                this.fullHeight = fval;
                this.timer = true
                let that = this
                setTimeout(function (){
                    that.timer = false
                },400)
            }
        }
    }

});

