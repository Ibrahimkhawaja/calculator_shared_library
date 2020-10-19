def call(body) {
    
    def res = new Adder().Add(4,2)

    println "$res"
    currentBuild.result = 'SUCCESS' //FAILURE to fail

    return this
}