# BiGramSpamFilter_2013
This application implements a Bi-Gram Spam Filter with HashMap in Java.</br>
The probability in a document with k n-grams (and hence k+n-1 words) is defined as the product of the individual probabilities, normalized by taking its k-th root as following: </br>

<a href="https://www.codecogs.com/eqnedit.php?latex=\sqrt[k]{\prod_{i=0}^{k-1}P(w_{i&plus;1}\cdots&space;w_{i&plus;1})}" target="_blank"><img src="https://latex.codecogs.com/gif.latex?\sqrt[k]{\prod_{i=0}^{k-1}P(w_{i&plus;1}\cdots&space;w_{i&plus;1})}" title="\sqrt[k]{\prod_{i=0}^{k-1}P(w_{i+1}\cdots w_{i+1})}" /></a>

,where
<a href="https://www.codecogs.com/eqnedit.php?latex=P(w_{i&plus;1}\cdots&space;w_{i&plus;1})" target="_blank"><img src="https://latex.codecogs.com/gif.latex?P(w_{i&plus;1}\cdots&space;w_{i&plus;1})" title="P(w_{i+1}\cdots w_{i+1})" /></a>
means number of occurrences of the n-gram.


LOG after execution shown as below:</br>
```
~/JavaWork/BigramSpamFilter (master ✘)✭ ᐅ java BigramSpamFilter
repeated key is found! key : percent of
repeated key is found! key : revealed that
repeated key is found! key : percent of
repeated key is found! key : more than
repeated key is found! key : that they
repeated key is found! key : monetary loss
repeated key is found! key : being phished
k is 157.0
Probability is :1.067310671465125
round answer: 1.06731
```
