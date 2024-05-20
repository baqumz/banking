const { createApp } = Vue;

createApp({
    data() {
        return {
            clientInfo: {},
            errorToats: null,
            errorMsg: null,
        }
    },
    methods: {
        getData() {
            //const urlParams = new URLSearchParams(window.location.search);
            //const id = urlParams.get('id');
            //axios.get(`/api/clients/${id}`)
            axios.get(`/api/clients/current`)
                .then((response) => {
                    console.log("RESPONSE");
                    console.log(response);
                    this.clientInfo = response.data;
                })
                .catch((error) => {
                    // handle error
                    this.errorMsg = "Error getting data";
                    this.errorToats.show();
                    console.log('Error');
                })
        },
        formatDate(date) {
            return new Date(date).toLocaleDateString('en-gb');
        }
    },
    mounted() {
        this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
        this.getData();
    }
}).mount('#app');