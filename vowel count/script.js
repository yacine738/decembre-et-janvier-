function checkVowels(){
    let text = document.getElementById("inputText").value;
    let vowelsCount=0;
    text=text.toLowerCase();
    for(let i=0;i<text.length;i++){
        let char = text.charAt(i);
        if (isVowel(char)){
            vowelsCount++;
        }
    }
    const result = document.getElementById('result');
    result.textContent ="Total vowels: " + vowelsCount;

}
function isVowel(char){
    const vowels = ["a","e","i","o","u","y","A","E","I","O","U","Y"]
    return vowels.includes(char);
}
