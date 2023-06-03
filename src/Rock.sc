;;; Sierra Script 1.0 - (do not remove this comment)
(script# 540)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use Cycle)
(use User)
(use Obj)

(public
	RM540 0
)

(local
	[local0 19] = [294 285 268 276 260 284 269 258 279 289 263 272 261 284 273 283 268 253 256]
	[local19 19] = [43 41 41 45 47 48 49 51 51 53 54 56 61 58 61 63 65 57 63]
	[local38 19] = [273 278 268 276 282 260 267 286 275 252 262 269 282 256 279 287 276 249 262]
	[local57 19] = [158 155 153 150 152 150 148 148 144 146 144 145 144 142 141 143 139 138 138]
	local76
	local77
	local78
	local79
	newList
	local81 =  1
)
(procedure (localproc_1e77)
	(if (proc819_5 324)
		(cond 
			(local81
				(cond 
					((< global244 1) (Palette palSET_FROM_RESOURCE 542 2))
					((and (< global244 2) (< 2 13)) (Palette palSET_FROM_RESOURCE 541 2))
				)
				(= local81 0)
			)
			((< global244 1) (Palette palSET_FROM_RESOURCE 542 2))
			((== global244 3) (Palette palSET_FROM_RESOURCE 541 2))
			((== global244 12) (Palette palSET_FROM_RESOURCE 540 2))
		)
	)
)

(instance RM540 of EcoRoom
	(properties
		picture 901
		style $0000
		north 561
		picAngle 80
		vanishingX 180
		vanishingY 10
	)
	
	(method (init &tmp [temp0 2] temp2 temp3)
		(= global250 3)
		(= global251 1)
		(= north
			(if (proc819_5 334) 560 else (proc819_4 107) 561)
		)
		(super init:)
		(switch gSouth
			(561
				(self setScript: fromToxicWasteInSuit)
			)
			(560
				(self setScript: fromToxicCaveScript)
			)
			(else 
				(self setScript: fromEntranceScript)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						45
						118
						125
						166
						125
						189
						161
						189
						172
						173
						244
						166
						297
						103
						247
						103
						275
						67
						269
						43
						216
						43
						216
						61
						111
						118
						121
						56
						45
						69
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 160 153 115 153 117 136 156 136
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 220 118 226 140 160 140 155 126 159 118
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 211 162 158 162 171 144 199 144
					yourself:
				)
		)
		(chest cel: (proc819_5 95))
		(gFeatures add: caveExit)
		(if (proc819_5 324)
			(gFeatures
				add: toxicCaveEntrance spiderWeb stalactite stalagmite caveExit
			)
		)
		(gFeatures eachElementDo: #init)
		(if (>= global244 14)
			(toxicCaveEntrance approachVerbs: 4)
		)
		(= temp2 (if (not (proc819_5 334)) 543 else 420))
		(if (!= (gLongSong number?) temp2)
			(gLongSong number: temp2 loop: -1 play:)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			((gEgo inRect: 53 90 103 142) (global2 newRoom: 520))
			((>= (gEgo y?) 88) 0)
			((and (not local77) (>= global244 14))
				(if (== north 561)
					(= local77 1)
					(= local79 1)
					((ScriptID 2 0) init: 1 0 0 9 1)
				else
					(global2 setScript: toToxicCave)
				)
			)
			((and (not local78) (< global244 6))
				(= local78 1)
				(= local79 1)
				((ScriptID 2 0) init: 1 0 0 16 1)
			)
			((not local79) (= local79 1) (EcoNarrator init: 3 0 0 20))
		)
		(super doit: &rest)
		(Palette palANIMATE 34 42 6)
	)
	
	(method (dispose)
		(if (not (== (Dummy 4 0) 2)) (DrawPic 901))
		(if (IsObject newList) (newList dispose:))
		(gDelph setScript: 0)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 324)
					(if (< ((User curEvent?) x?) 180)
						(EcoNarrator init: 3 0 0 2)
					else
						(EcoNarrator init: 3 0 0 3)
					)
				else
					(EcoNarrator init: 3 0 0 17)
				)
			)
			(4
				(if (proc819_5 324)
					(super doVerb: theVerb theTheVerb)
				else
					(EcoNarrator init: 3 0 0 25)
				)
			)
			(44
				(cond 
					((proc819_5 324) (super doVerb: theVerb theTheVerb))
					((and (== theTheVerb 41) (== global233 2)) (self setScript: releaseFish))
					(else (EcoNarrator init: 3 0 0 33))
				)
			)
			(2
				(cond 
					((proc819_5 324) (EcoNarrator init: 3 0 0 39))
					((proc819_5 73) (super doVerb: 2))
					(else (self setScript: scareDel))
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
	
	(method (newRoom)
		(global2 drawPic: 901 -32759)
		(super newRoom: &rest)
	)
	
	(method (notify)
		(if argc
			(if (not (== (Dummy 4 0) 2))
				(if (not (proc819_5 324))
					(Palette palSET_INTENSITY 116 155 0)
					(Palette palSET_INTENSITY 156 255 0)
				else
					(Palette palSET_INTENSITY 116 155 100)
					(Palette
						palSET_INTENSITY
						156
						255
						(proc999_2 (+ 25 (* 9 global244)) 110)
					)
				)
			else
				(self setScript: resetScreen)
			)
		else
			(self setScript: releaseFish)
		)
	)
)

(instance fromEntranceScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= ticks 1))
			(1
				(self setScript: resetScreen self)
			)
			(2
				(proc819_6)
				(gEgo
					loop: 5
					heading: 135
					ignoreHorizon: 1
					init:
					posn: 86 80 28
					setMotion: MoveTo 124 173 self
				)
			)
			(3
				(if (not (proc819_5 334))
					(proc819_7)
					(gDelph
						init:
						setPri: 2
						posn: 41 158
						setScript: (ScriptID 127 0) 0 920
						setMotion: MoveTo 95 195 self
					)
				else
					(= ticks 1)
				)
				(if (and (>= global244 13) (not (proc819_5 334)))
					(glint init:)
				)
			)
			(4 (= seconds 2))
			(5
				(if (and (< 1 global244) (< global244 14))
					((ScriptID 2 0) init: 1 0 0 18 1 self)
				else
					(= ticks 1)
				)
			)
			(6
				(proc0_2)
				(if
				(and (not (proc819_5 324)) (not (gEgo script?)))
					(global2 setScript: 0)
					(gEgo setScript: tooDarkScript)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance resetScreen of Script
	(properties)
	
	(method (changeState newState &tmp temp0 newRock)
		(switch (= state newState)
			(0
				(if (IsObject newList) (newList dispose:))
				(if (not (== (Dummy 4 0) 2))
					(if (not (proc819_5 324))
						(Palette palSET_INTENSITY 116 155 0)
						(Palette palSET_INTENSITY 156 255 0)
					else
						(Palette palSET_INTENSITY 116 155 100)
						(Palette
							palSET_INTENSITY
							156
							255
							(proc999_2 (+ 25 (* 9 global244)) 110)
						)
					)
					(global2 drawPic: 540 9)
				else
					(= local81 1)
					(global2 drawPic: 541)
					(localproc_1e77)
				)
				(= newList (List new:))
				(= temp0 0)
				(while (< temp0 19)
					(if (< temp0 global244)
						((= newRock (Rock new:))
							posn: [local38 temp0] [local57 temp0]
							setPri: 6
							cel: (if (> global102 16) 0 else 1)
							init:
						)
					else
						((= newRock (Rock new:))
							posn: [local0 temp0] [local19 temp0]
							init:
						)
						(if (not (proc819_5 324)) (newRock hide:))
					)
					(newList add: newRock)
					(++ temp0)
				)
				(= cycles 2)
			)
			(1 (self dispose:))
		)
	)
)

(instance tooDarkScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gDelph setMotion: MoveTo 156 176 self)
			)
			(1
				((ScriptID 2 0) init: 1 0 0 1 1 self)
			)
			(2 (= seconds 8))
			(3
				(proc0_1)
				((ScriptID 2 0) init: 1 0 0 1 1 self)
			)
			(4
				(gDelph setMotion: MoveTo 150 178)
				(gEgo setMotion: PolyPath 72 70 self)
			)
			(5
				(global2 drawPic: 901 -32768)
				(= cycles 2)
			)
			(6 (global2 newRoom: 520))
		)
	)
)

(instance releaseFish of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 90 self setScript: 0)
			)
			(1
				(gEgo setCycle: 0 view: 540 setLoop: 2 cel: 0)
				(= cycles 20)
			)
			(2
				(EcoNarrator init: 3 0 0 27 self)
			)
			(3
				(proc0_4 10 324)
				(gEgo cycleSpeed: 20 setCycle: End self)
				(if (not (== (Dummy 4 0) 2))
					(newList eachElementDo: #show)
					(Palette palSET_INTENSITY 116 155 100)
					(Palette palSET_INTENSITY 156 255 25)
				else
					(localproc_1e77)
					(newList eachElementDo: #setCel 0)
					(newList eachElementDo: #show)
				)
				(= cycles 1)
			)
			(4 0)
			(5
				(EcoNarrator init: 3 0 0 28 self)
			)
			(6 (= seconds 2))
			(7
				((ScriptID 2 0) init: 1 0 0 26 1 self)
			)
			(8
				(EcoNarrator init: 3 0 0 42 self)
			)
			(9
				(gEgo put: 32)
				(gFeatures
					add: toxicCaveEntrance spiderWeb stalactite stalagmite caveExit
					eachElementDo: #init
				)
				(proc819_6)
				(gEgo z: 28 heading: 90 loop: 0)
				(self dispose:)
			)
		)
	)
)

(instance scareDel of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 3 0 0 26 self)
			)
			(1
				((ScriptID 2 0) init: 1 0 0 14 1 self)
			)
			(2
				((ScriptID 2 1) init: 2 0 0 7 1 self)
			)
			(3 (self dispose:))
		)
	)
)

(instance fromToxicCaveScript of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: resetScreen self)
			)
			(1
				(proc819_6)
				(toxicCaveEntrance approachVerbs: 4)
				(gEgo
					ignoreHorizon: 1
					init:
					posn: 278 63
					z: 28
					setMotion: MoveTo 230 107 self
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance fromToxicWasteInSuit of HandsOffScript
	(properties)
	
	(method (changeState newState &tmp temp0)
		(asm
			lap      newState
			aTop     state
			push    
			dup     
			ldi      0
			eq?     
			bnt      code_0c04
			pushi    #setScript
			pushi    2
			lofsa    resetScreen
			push    
			pushSelf
			self     8
			jmp      code_0dfa
code_0c04:
			dup     
			ldi      1
			eq?     
			bnt      code_0c6c
			pushi    #ignoreHorizon
			pushi    1
			pushi    1
			pushi    110
			pushi    0
			pushi    2
			pushi    1
			pushi    542
			pushi    153
			pushi    3
			pushi    254
			pushi    51
			pushi    0
			pushi    155
			pushi    1
			pushi    2
			pushi    161
			pushi    1
			class    Fwd
			push    
			pushi    290
			pushi    4
			class    MoveTo
			push    
			pushi    243
			pushi    77
			pushSelf
			lag      gEgo
			send     50
			pushi    0
			calle    proc819_7,  0
			pushi    #init
			pushi    0
			pushi    63
			pushi    1
			pushi    2
			pushi    153
			pushi    2
			pushi    41
			pushi    158
			pushi    290
			pushi    3
			class    MoveTo
			push    
			pushi    95
			pushi    195
			lag      gDelph
			send     28
			jmp      code_0dfa
code_0c6c:
			dup     
			ldi      2
			eq?     
			bnt      code_0ca4
			pushi    #view
			pushi    1
			pushi    541
			pushi    153
			pushi    3
			pushi    225
			pushi    98
			pushi    28
			pushi    155
			pushi    1
			pushi    3
			pushi    4
			pushi    1
			pushi    6
			pushi    247
			pushi    1
			pushi    20
			pushi    161
			pushi    2
			class    Beg
			push    
			pushSelf
			lag      gEgo
			send     42
			jmp      code_0dfa
code_0ca4:
			dup     
			ldi      3
			eq?     
			bnt      code_0ce4
			pushi    #setLoop
			pushi    1
			pushi    2
			pushi    4
			pushi    1
			pushi    10
			pushi    161
			pushi    2
			class    Beg
			push    
			pushSelf
			lag      gEgo
			send     20
			pushi    1
			pushi    97
			calle    proc819_4,  2
			pushi    #init
			pushi    0
			pushi    4
			pushi    1
			pushi    0
			lofsa    glint
			send     10
			pushi    #approachVerbs
			pushi    1
			pushi    4
			lofsa    toxicCaveEntrance
			send     6
			jmp      code_0dfa
code_0ce4:
			dup     
			ldi      4
			eq?     
			bnt      code_0d16
			pushi    1
			pushi    134
			calle    proc819_5,  2
			bnt      code_0cfe
			ldi      1
			aTop     ticks
			jmp      code_0dfa
code_0cfe:
			pushi    #setScript
			pushi    2
			lofsa    foundToxicWaste
			push    
			pushSelf
			self     8
			pushi    1
			pushi    134
			calle    proc819_3,  2
			jmp      code_0dfa
code_0d16:
			dup     
			ldi      5
			eq?     
			bnt      code_0d46
			pushi    0
			calle    proc819_6,  0
			pushi    #posn
			pushi    3
			pushi    227
			pushi    102
			pushi    28
			pushi    290
			pushi    4
			class    MoveTo
			push    
			pushi    218
			pushi    130
			pushSelf
			lag      gEgo
			send     22
			jmp      code_0dfa
code_0d46:
			dup     
			ldi      6
			eq?     
			bnt      code_0def
			pushi    #has
			pushi    1
			pushi    31
			lag      gEgo
			send     6
			bt       code_0d63
			pushi    1
			pushi    332
			calle    proc819_5,  2
code_0d63:
			not     
			bnt      code_0d85
			pushi    #has
			pushi    1
			pushi    30
			lag      gEgo
			send     6
			bt       code_0d7d
			pushi    1
			pushi    331
			calle    proc819_5,  2
code_0d7d:
			not     
			bnt      code_0d85
			ldi      24
			jmp      code_0dc2
code_0d85:
			pushi    #has
			pushi    1
			pushi    31
			lag      gEgo
			send     6
			bt       code_0d9b
			pushi    1
			pushi    332
			calle    proc819_5,  2
code_0d9b:
			not     
			bnt      code_0da3
			ldi      23
			jmp      code_0dc2
code_0da3:
			pushi    #has
			pushi    1
			pushi    30
			lag      gEgo
			send     6
			bt       code_0db9
			pushi    1
			pushi    331
			calle    proc819_5,  2
code_0db9:
			not     
			bnt      code_0dc0
			ldi      22
			jmp      code_0dc2
code_0dc0:
			ldi      25
code_0dc2:
			sat      temp0
			pushi    #init
			pushi    6
			pushi    1
			pushi    0
			pushi    0
			push    
			pushi    1
			pushSelf
			pushi    2
			pushi    2
			pushi    0
			callk    ScriptID,  4
			send     16
			pushi    #register
			pushi    1
			lst      temp0
			lofsa    delTalkAfterToxicCave
			send     6
			pushi    #talkScript
			pushi    1
			lofsa    delTalkAfterToxicCave
			push    
			lag      gDelph
			send     6
			jmp      code_0dfa
code_0def:
			dup     
			ldi      7
			eq?     
			bnt      code_0dfa
			pushi    #dispose
			pushi    0
			self     4
code_0dfa:
			toss    
			ret     
		)
	)
)

(instance foundToxicWaste of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 42 0 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 43 0 self)
			)
			(2
				((ScriptID 2 1) init: 2 0 0 49 1 self)
			)
			(3
				((ScriptID 2 0) init: 1 0 0 19 1 self)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 44 0 self)
			)
			(5
				((ScriptID 2 1) init: 2 0 0 45 1 self)
			)
			(6
				((ScriptID 2 0) init: 1 0 0 20 1 self)
			)
			(7
				((ScriptID 2 1) init: 2 0 0 46 1 self)
			)
			(8 (self dispose:))
		)
	)
)

(instance toToxicCave of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo ignoreHorizon: 1 setMotion: MoveTo 309 44 self)
			)
			(1 (global2 newRoom: 560))
		)
	)
)

(instance pullRock of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (gEgo setHeading: 0 self))
			(1
				(gEgo
					setCycle: 0
					setPri: 13
					view: 805
					setCycle: Fwd
					y: (- (gEgo y?) 28)
					z: 0
					setMotion: MoveTo (- (register x?) 24) (- (register y?) 5) self
				)
			)
			(2
				(register startUpd: setPri: 6)
				(gEgo
					view: 543
					setLoop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: CT 10 1 self
				)
			)
			(3
				(gSoundEffects number: 541 loop: 1 play:)
				(register
					setMotion:
						MoveTo
						[local38 global244]
						[local57 (gEgo
							setCycle: End
							setStep: 1 2
							setMotion: MoveTo (gEgo x?) 80
						)]
						self
				)
				(++ global244)
				(if (not (== (Dummy 4 0) 2))
					(Palette
						palSET_INTENSITY
						156
						255
						(proc999_2 (+ 25 (* 9 global244)) 110)
					)
				else
					(localproc_1e77)
				)
			)
			(4
				(gSoundEffects number: 540 loop: 1 play:)
				(switch global244
					(1
						(EcoNarrator init: 3 0 0 31 self)
					)
					(2
						(EcoNarrator init: 3 0 0 19 self)
					)
					(4
						(self setScript: easyRocks self)
					)
					(7
						(EcoNarrator init: 3 0 0 32 self)
					)
					(10
						(self setScript: dontStop self)
					)
					(13
						(toxicCaveEntrance approachVerbs: 4)
						(= ticks 1)
					)
					(else 
						(if (and (>= global244 14) (not (proc819_5 334)))
							(proc0_4 5 325)
							(self setScript: showGlint self)
						else
							(= ticks 1)
						)
					)
				)
			)
			(5
				(register stopUpd:)
				(proc819_6)
				(gEgo heading: 0 loop: 3 y: (+ (gEgo y?) 36) z: 28)
				(= local79 0)
				(self dispose:)
			)
		)
	)
)

(instance easyRocks of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 12 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 5 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance dontStop of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 6 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 8 1 self)
			)
			(2
				((ScriptID 2 0) init: 1 0 0 17 1 self)
			)
			(3 (self dispose:))
		)
	)
)

(instance showGlint of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc819_5 329))
					(EcoNarrator init: 3 0 0 5 self)
				else
					(= ticks 2)
				)
			)
			(1
				(if (not (gCast contains: glint)) (glint init:))
				(glint cel: 0 setCycle: End self)
			)
			(2 (self dispose:))
		)
	)
)

(instance putOnSuit of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 238 113 self)
			)
			(1 (gEgo setHeading: 180 self))
			(2
				(proc0_4 10 329)
				(proc819_3 97)
				(gEgo
					setCycle: 0
					view: 541
					posn: 225 70 0
					setLoop: 2
					cel: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(if (proc819_5 147)
					(= state (+ state 2))
					(EcoNarrator init: 3 0 0 43 self)
				else
					(proc819_3 147)
					(EcoNarrator init: 3 0 0 14 self)
				)
			)
			(5
				(if
					(and
						(or (gEgo has: 30) (proc819_5 331))
						(or (gEgo has: 31) (proc819_5 332))
					)
					((ScriptID 2 0) init: 1 0 0 7 1 self)
				else
					((ScriptID 2 0) init: 1 0 0 21 1 self)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 15 self)
			)
			(7
				(gEgo
					view: 542
					posn: 243 77
					setLoop: 3
					setMotion: MoveTo 254 51 self
				)
			)
			(8 (global2 newRoom: 561))
		)
	)
)

(instance chestOpenTalk of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 3 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 3 0 self)
			)
			(2
				((ScriptID 2 1) init: 2 0 0 4 1 self)
			)
			(3 (self dispose:))
		)
	)
)

(instance chestClosedTalk of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator posn: -1 140 init: 3 0 0 6 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 2 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance delTalkAfterToxicCave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 register 1 self)
			)
			(1 (self dispose:))
		)
	)
)

(class Rock of EcoActor
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 255
		approachY 78
		approachDist 0
		_approachVerbs 0
		yStep 6
		view 543
		loop 0
		cel 0
		priority 1
		underBits 0
		signal $6810
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
		illegalBits $0000
		xLast 0
		yLast 0
		xStep 3
		origStep 770
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
		lookStr 0
	)
	
	(method (init)
		(self approachVerbs: 4)
		(super init: &rest)
		(self stopUpd:)
	)
	
	(method (doVerb theVerb &tmp theTheVerb temp1)
		(if (not (proc819_5 324))
			(global2 doVerb: theVerb theTheVerb)
		else
			(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
				(= theTheVerb theVerb)
				(= theVerb 44)
			)
			(switch theVerb
				(4
					(cond 
						((not (proc819_5 324)) (EcoNarrator init: 3 0 0 17))
						((> y 130) (EcoNarrator init: 3 0 0 22))
						(else
							(= temp1 (newList at: global244))
							(global2 setScript: pullRock 0 temp1)
						)
					)
				)
				(1
					(cond 
						((> y 130) (EcoNarrator init: 3 0 0 21))
						(global244 (EcoNarrator init: 3 0 0 40))
						(else (EcoNarrator init: 3 0 0 4))
					)
				)
				(44
					(switch theTheVerb
						(29
							(EcoNarrator init: 3 0 0 18)
						)
						(else 
							(super doVerb: theVerb theTheVerb &rest)
						)
					)
				)
				(else 
					(super doVerb: theVerb theTheVerb &rest)
				)
			)
		)
	)
)

(instance glint of EcoProp
	(properties
		x 252
		y 101
		approachX 250
		approachY 109
		view 823
		signal $4000
	)
	
	(method (init)
		(self approachVerbs: 1 4)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(global2 setScript: showChestInset)
			)
			(4
				(global2 setScript: showChestInset)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
	
	(method (cue)
		(self cel: 0 setCycle: End)
	)
)

(instance toxicCaveEntrance of EcoFeature
	(properties
		x 260
		y 10
		onMeCheck $4000
		approachX 262
		approachY 50
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc819_5 324))
			(global2 doVerb: theVerb theTheVerb)
		else
			(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
				(= theTheVerb theVerb)
				(= theVerb 44)
			)
			(switch theVerb
				(4
					(if (< global244 15) (EcoNarrator init: 3 0 0 34))
				)
				(1
					(cond 
						((not global244) (EcoNarrator init: 3 0 0 4))
						((>= global244 14) (EcoNarrator init: 3 0 0 35))
						(else (EcoNarrator init: 3 0 0 34))
					)
				)
				(else 
					(super doVerb: theVerb theTheVerb &rest)
				)
			)
		)
	)
)

(instance spiderWeb of EcoFeature
	(properties
		onMeCheck $2000
		lookStr 36
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x ((User curEvent?) x?))
		(= y ((User curEvent?) y?))
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 37))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stalactite of EcoFeature
	(properties
		onMeCheck $1000
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(global2 setScript: stalTalk)
				)
			)
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 3 0 0 23)
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance stalagmite of EcoFeature
	(properties
		onMeCheck $0800
	)
	
	(method (doVerb)
		(stalactite doVerb: &rest)
	)
)

(instance stalTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 13 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 6 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance caveExit of EcoFeature
	(properties
		x 99
		y 114
		onMeCheck $0400
		approachX 72
		approachY 90
		lookStr 41
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(global2 newRoom: 520)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chestInset of EcoView
	(properties
		x 170
		y 298
		z 200
		view 540
		priority 11
		signal $5811
	)
	
	(method (init)
		(super init:)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(!= (pEvent type?) evVERB)
				(not (pEvent modifiers?))
				(not
					(proc999_5
						(pEvent message?)
						9
						17
						15104
						15360
						16128
						16640
						17152
					)
				)
				(not (proc999_4 nsLeft nsTop nsRight nsBottom pEvent))
				(not (& (pEvent type?) $000a))
			)
			(pEvent claimed: 1)
			((global2 script?) cue:)
		else
			(super handleEvent: pEvent &rest)
		)
	)
)

(instance chest of EcoView
	(properties
		x 173
		y 299
		z 200
		view 540
		loop 1
		priority 13
		signal $4811
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if cel
			(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
				(= theTheVerb theVerb)
				(= theVerb 44)
			)
			(switch theVerb
				(1
					(if (proc819_5 148)
						(EcoNarrator init: 3 0 0 44)
					else
						(proc819_3 148)
						(gEgo setScript: chestOpenTalk)
					)
				)
				(4
					(= cel 0)
					(proc819_4 95)
					(suitInChest dispose:)
					(self forceUpd:)
				)
				(else 
					(super doVerb: theVerb theTheVerb &rest)
				)
			)
		else
			(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
				(= theTheVerb theVerb)
				(= theVerb 44)
			)
			(switch theVerb
				(1
					(gEgo setScript: chestClosedTalk)
				)
				(4
					((ScriptID 2 1) init: 2 0 0 1 1)
				)
				(44
					(switch theTheVerb
						(42
							(EcoNarrator posn: -1 154 init: 3 0 0 11)
							(proc0_4 5 327)
						)
						(33
							(if (proc819_5 327)
								(if (proc819_5 150)
									(chest cel: 1 forceUpd:)
									(if (not (proc819_5 97)) (suitInChest init: stopUpd:))
									(proc819_3 95)
								else
									(proc819_3 150)
									(gEgo setScript: openChest)
								)
							else
								(EcoNarrator posn: -1 154 init: 3 0 0 10)
							)
						)
						(29
							(EcoNarrator posn: -1 154 init: 3 0 0 9)
						)
						(37
							(EcoNarrator posn: -1 154 init: 3 0 0 9)
						)
						(else 
							(if (proc819_5 327)
								(super doVerb: theVerb theTheVerb)
							else
								(EcoNarrator posn: -1 154 init: 3 0 0 13)
							)
						)
					)
				)
				(else 
					(super doVerb: theVerb theTheVerb &rest)
				)
			)
		)
	)
)

(instance openChest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(chest cel: 1 forceUpd:)
				(EcoNarrator posn: -1 154 init: 3 0 0 30 self)
			)
			(1
				(if (not (proc819_5 97)) (suitInChest init: stopUpd:))
				(proc0_4 5 328)
				(proc819_3 95)
				(= seconds 3)
			)
			(2
				((ScriptID 2 0) init: 1 0 0 3 1 self)
			)
			(3
				((ScriptID 2 1) init: 2 0 0 3 0 self)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 4 1 self)
			)
			(5 (self dispose:))
		)
	)
)

(instance suitInChest of EcoView
	(properties
		x 173
		y 300
		z 200
		view 540
		loop 1
		cel 2
		priority 14
		signal $4811
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc819_5 148)
					(EcoNarrator init: 3 0 0 44)
				else
					(proc819_3 148)
					(gEgo setScript: chestOpenTalk)
				)
			)
			(4
				(= local76 1)
				((global2 script?) cue:)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance showChestInset of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= ticks 3))
			(1
				(chestInset init:)
				(chest init:)
				(proc0_4 5 326)
				(if (and (proc819_5 95) (not (proc819_5 97)))
					(suitInChest init:)
				)
				(= cycles 3)
			)
			(2
				(EcoNarrator posn: -1 154 init: 3 0 0 6 self)
			)
			(3
				(proc0_2)
				(gIconBar disable: 0 6)
				(gIconBar curIcon: (gIconBar at: 2))
			)
			(4
				(gCast eachElementDo: #startUpd)
				(proc819_6)
				(= cycles 1)
			)
			(5
				(chest dispose:)
				(suitInChest dispose:)
				(chestInset dispose:)
				(= cycles 2)
			)
			(6
				(proc0_2)
				(if local76
					(= local76 0)
					(client setScript: putOnSuit)
				else
					(self dispose:)
				)
			)
		)
	)
)
