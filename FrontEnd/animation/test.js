function func1(){
    func2();
}

function func2(){
    func3();
}

function func3(){
    console.log('func3');
}

func1();

function func4(){
    console.log('func4');
    func5();
}

function func5(){
    setTimeout(
        function(){
            console.log('func5');
        },0
    );
    func6();
}

function func6(){
    console.log('func6');
}