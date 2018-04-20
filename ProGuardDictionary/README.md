# Custom dictionary for ProGuard
Customising the dictionary for proguard with names that consist only of 1, capital i, and lower case l

## How to use
```
-obfuscationdictionary method-dictionary.txt
-packageobfuscationdictionary package-dictionary.txt
-classobfuscationdictionary class-dictionary.txt
```
I have named our custom ones according to the ProGuard flag

### References
* https://proandroiddev.com/improving-proguard-name-obfuscation-83b27b34c52a
* https://www.guardsquare.com/en/proguard/manual/usage#obfuscationoptions

## How they were generated
* Generate the words http://www.dave-reed.com/Nifty/randSeq.html
* Make them one word per line https://www.browserling.com/tools/spaces-to-newlines
* Remove duplicates with http://www.dedupelist.com/index.html or http://tools.dynamicdrive.com/listscrubber/
* Remove those starting with 1 using ^(1).* https://myeasywww.appspot.com/utility/free/online/Remove_lines_matching_a_regular_expression/en?command=UTILITY&ID=20
