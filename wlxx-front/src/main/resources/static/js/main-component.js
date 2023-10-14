import { ref } from 'vue'
export default {
  setup() {
    const name = ref("xzg")
    const age = ref(11)
    const accept = ref(false)

    const onSubmit = function() {
        if (accept !== true) {
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
        name = null
        age = null
        accept = false
    }
    return { name,age,accept,onSubmit,onReset }
  }
}

