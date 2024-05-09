Vue.createApp({
    data() {
        return {
            clientInfo: {},
            creditCards: [],
            debitCards: [],
            errorToats: null,
            errorMsg: null,
        }
    },
    methods: {
        getData: function () {
            axios.get("/api/clients/1")
                .then((response) => {
                    this.clientInfo = response.data;
                    this.creditCards = response.data.cards.filter(card => card.type == "CREDIT");
                    this.debitCards = response.data.cards.filter(card => card.type == "DEBIT");
                    console.log(this.clientInfo);
                    console.log(this.creditCards);
                    console.log(this.debitCards);
                })
                .catch((error) => {
                    this.errorMsg = "Error getting data";
                    this.errorToats.show();
                })
        },
        formatDate: function (date) {
            return new Date(date).toLocaleDateString('en-gb');
        }
    },
    mounted: function () {
        this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
        this.getData();
    }
}).mount('#app')