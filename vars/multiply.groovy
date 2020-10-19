def call(body) {
    
    def res = new Multiplier().Multiply(4,2)

    echo "$res"
    //currentBuild.result = 'SUCCESS' //FAILURE to fail

    return this
}
