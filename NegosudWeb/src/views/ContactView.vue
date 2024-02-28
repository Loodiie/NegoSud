<script setup>
import HeaderWeb from '../components/layout/HeaderWeb.vue';
import FooterWeb from '../components/layout/FooterWeb.vue';
</script>

<template>
    <HeaderWeb />

    <form class="container min-vh-100" @submit.prevent="sendEmail">
        <div class="mb-3">
            <label for="inputEmailAddress" class="form-label">Votre adresse mail</label>
            <input type="email" class="form-control" id="inputEmailAddress" placeholder="paul.dupont@exemple.com" v-model="senderEmail">
        </div>
        <div class="mb-3">
            <label for="inputSubject" class="form-label">Sujet de votre demande</label>
            <input type="text" class="form-control" id="inputSubject" placeholder="Le sujet de votre demande" v-model="subject">
        </div>
        <div class="mb-3">
            <label for="inputMessage" class="form-label">Comment pouvons-nous vous aider ?</label>
            <textarea class="form-control" id="inputMessage" rows="5" placeholder="Votre message ici..." v-model="message"></textarea>
        </div>
        <button type="submit" class="btn btn-primary mb-3">Envoyer</button>
    </form>

    <FooterWeb />
</template>
