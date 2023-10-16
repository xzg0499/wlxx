import { ref } from 'vue'
export default {
  setup() {
    const $q = Quasar.useQuasar()
    const name = ref("xzg")
    const age = ref(11)
    const accept = ref(false)

    const onSubmit = function() {
        if (accept.value !== true) {
          $q.notify({
            color: 'red-5',
            textColor: 'white',
            icon: 'warning',
            message: 'You need to accept the license and terms first'
          })
        }
        else {
          $q.notify({
            color: 'green-4',
            textColor: 'white',
            icon: 'cloud_done',
            message: 'Submitted'
          })
        }
    }

    const onReset =function() {
        name.value = null
        age.value = null
        accept.value = false
    }
    return { name,age,accept,onSubmit,onReset }
  },
  template: `<q-form
                         @submit="onSubmit"
                         @reset="onReset"
                         class="q-gutter-md"
                 >
                     <q-input
                             filled
                             v-model="name"
                             label="Your name *"
                             hint="Name and surname"
                             lazy-rules
                             :rules="[ val => val && val.length > 0 || 'Please type something']"
                     ></q-input>

                     <q-input
                             filled
                             type="number"
                             v-model="age"
                             label="Your age *"
                             lazy-rules
                             :rules="[
                       val => val !== null && val !== '' || 'Please type your age',
                       val => val > 0 && val < 100 || 'Please type a real age'
                     ]"
                     ></q-input>

                     <q-toggle v-model="accept" label="I accept the license and terms"></q-toggle>

                     <div>
                         <q-btn label="Submit" type="submit" color="primary"></q-btn>
                         <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm"></q-btn>
                     </div>
                 </q-form>`
}

