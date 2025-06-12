# Java 7 Performance Testing

TODO...

Meanwhile, here's a frog

```
            _     _
           (')-=-(')
         __(   "   )__
        / _/'-----'\_ \
     ___\\ \\     // //___
jgs  >____)/_\---/_\(____<
```

## Results

| Benchmark                                      | Mode | Cnt | Score      | Error    | Units |
|------------------------------------------------|------|-----|------------|----------|-------|
| SetDebtRegexMethod.setDebtRegexParsing         | avgt | 30  | 479132,600 | 3400,305 | ns/op |
| SetDebtStringMethod.setDebtStringParsing       | avgt | 30  | 106157,421 | 2538,565 | ns/op |
| SetDebtCharArrayMethod.setDebtCharArrayParsing | avgt | 30  | 993469,015 | 2538,565 | ns/op |

No idea how I managed to make setDebtCharArrayParsing slower than everything else...