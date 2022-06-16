### 6.0-beta6
- Tweaked the dropping probabilities and amount. Calculate them (of the deepslate ones) with C(5,r)\*0.4<sup>r</sup>\*(1-0.4)<sup>5-r</sup>, where `r` is the amount of items dropped. Replace 0.4 with 0.42 to calculate for normal ones. In this modification, siderite will yield (on average) 1 (deepslate) to 1.05 (normal) iron ingots.
- Note: "depack"-ing a pack of powder and then smelt will be 10% faster, but will also gain 10% less experience.

From this version on, version names will use the English name of Greek letters to avoid character obfuscation due to encoding difference.

#### 6.0-α53
- Hotfix for β5. Tweaked "Raw Iron Block" to "Siderite Block"

### 6.0-β5
- Added all stuff in β4 to deepslate.
- Added more recipes.
- Raw Iron Block now drops 18 packs of siderite powder

### 6.0-β4
- Iron ore (now called "siderite") now drops at most 12, on average 7.2 siderite powders. 9 siderite powders form a pack of siderite powder. 2 packs of siderite powder and 1 pack of coal powder can craft a "Siderite Powder Mixed with Coal". On smelting this mixture undergo the reaction of 2FeCO₃ + C --heat-> 2Fe + 3CO₂ and forms raw iron. Melt the raw iron again forms iron ingot.
- Known bugs/non-scientific stuff: smelting siderite items will yield Fe₂O₃. It has no texture and no use.

Appendix:<br>
The possibility of each dropping amount of siderite powder of iron ore is in the following table:
| Amount | Possibility (in %) |
| ------ | ----------- |
| 0 | 0.00168 |
| 1 | 0.03020 |
| 2 | 0.24914 |
| 3 | 1.24571 |
| 4 | 4.20427 |
| 5 | 10.09023 |
| 6 | 17.65791 |
| 7 | 22.70303 |
| 8 | 21.28409 |
| 9 | 14.18940 |
| 10 | 6.38523 |
| 11 | 1.74143 |
| 12 | 0.21768 |

The possibility of each dropping amount of siderite powder of **deepslate** iron ore is in the following table:
| Amount | Possibility (in %) |
| ------ | ----------- |
| 0 | 0.00005 |
| 1 | 0.00184 |
| 2 | 0.02949 |
| 3 | 0.27525 |
| 4 | 1.65151 |
| 5 | 6.60603 |
| 6 | 17.61608 |
| 7 | 30.19899 |
| 8 | 30.19899 |
| 9 | 13.42177 |

### 6.0-β3
- Iron shovel and hoe now rusts at the same speed as iron pickaxe.

### 6.0-β2
- Iron axe now rusts. Ticks are (in ticks): 48000, 45000, 42000, 36000, 32000.
- Tweaked the rusting time of unrusted iron pickaxe from 42000 to 44000 ticks.
- Updated README.md to make it look a little better.

### 6.0-β1
First notable milestone! Changes:
- Iron pickaxe now rusts. It has six steps: unrusted, slightly rusted, mildly rusted, moderately rusted, heavily rusted and completely rusted. The first 5 steps needs following time before entering the next step (in ticks): 42000, 40000, 36000, 32000, 24000. 
- Added triirontetraoxide ingot and dust. 1 ingot <-> 9 dusts; 8 dusts round + 1 iron ingot in the middle -> 1 netherite scrap; 1 netherite ingot -> 1 triirontetraoxide ingot. Currently doesn't have any usefulness.
- Also has triitontetraoxide sword but can only be obtained by command or creative mode; triitontetraoxide tools doesn't have a texture for now and cannot be obtained in survival mode.
- Currently has English and Chinese translation. 