;;; Sierra Script 1.0 - (do not remove this comment)
(script# 0)
(include sci.sh)
(use n804)
(use EcoRoom)
(use Smopper)
(use EcoWindow)
(use n819)
(use EcoFeature)
(use EcoDialog)
(use Cursor)
(use RTRandCycle)
(use PseudoMouse)
(use IconI)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Grooper)
(use Ego)
(use Sound)
(use Game)
(use InvI)
(use Obj)

(public
	eco 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	invC 7
	arrowC 8
	eyeC 9
	helpC 10
	handC 11
	speedORama 12
)

(local
	gEgo
	gGame
	global2
	global3
	global4
	gCast
	gRegions
	gTimers
	gSounds
	gInv
	gAddToPics
	gNumber
	gSouth
	gNewRoomNumber
	global14
	global15
	global16
	global17
	global18
	gCursorNumber
	gArrowC =  999
	gWaitC =  997
	gFont =  1
	global23 =  4
	gPEvent
	gTheNewEcoDialog
	global26 =  1
	global27
	global28
	global29
	global30
	gPicAngle
	gFeatures
	global33
	global34
	global35
	gPicNumber =  -1
	global37
	gEcoWin
	global39
	global40
	global41
	global42
	global43
	global44
	global45
	global46
	global47
	global48
	global49
	global50
	global51
	global52
	global53
	global54
	global55
	global56
	global57
	global58
	global59
	global60
	global61
	global62
	gGameControls
	gEcoFtrInit
	gEcoDoVerbCode
	gEcoApproachCode
	global67 =  1
	global68
	gIconBar
	gPEventX
	gPEventY
	gEcoKeyDownHandler
	gEcoMouseDownHandler
	gEcoDirectionHandler
	global75
	global76
	gPseudoMouse
	gTheDoits
	gEatTheMice =  60
	gUser
	global81
	gNewSync
	global83
	gNewEventHandler
	gFont_2
	global86
	global87
	gCycleCnt
	global89
	global90 =  1
	global91
	global92
	gWalkHandler
	global94 =  2
	global95
	global96
	global97
	global98
	global99
	gLongSong
	global101 =  1234
	global102
	global103
	global104
	global105
	global106
	gProphesyScrollY
	gStopGroop
	global109
	global110
	global111
	global112
	global113
	global114
	global115
	global116
	gSoundEffects
	global118 =  1
	global119
	global120
	global121
	global122
	global123
	global124
	global125
	global126
	global127
	global128
	global129
	global130
	global131
	global132
	global133
	global134
	global135
	global136
	global137
	global138
	global139
	global140
	global141
	global142
	global143
	global144
	global145
	global146
	global147
	global148
	global149
	global150
	global151
	global152
	global153
	global154
	global155
	global156
	global157
	global158
	global159
	global160
	global161
	global162
	global163
	global164
	global165
	global166
	global167
	global168
	global169
	global170
	global171
	global172
	global173
	global174
	global175
	global176
	global177
	global178
	global179
	global180
	global181
	global182
	global183
	gTheTilePieceCorrectPosn
	global185
	global186
	global187
	global188
	global189
	global190
	global191
	global192
	global193
	global194
	global195
	global196
	global197
	global198
	global199
	global200
	global201
	global202
	gMidBordColor
	global204
	global205
	global206
	gInnerBordColor
	global208
	gOuterBordColor
	gBack
	global211
	global212
	global213
	global214
	global215
	global216
	gColor
	global218
	global219
	global220
	global221
	global222
	global223
	global224
	global225
	gDelph
	global227
	global228
	gBelongsTo
	global230
	gLongSong2
	global232
	global233
	global234
	global235
	global236
	global237
	global238
	global239
	global240
	global241
	global242
	global243 =  100
	global244
	global245
	global246 =  1
	global247 =  1
	global248
	global249 =  42
	global250 =  3
	global251
	global252 =  6
)
(procedure (proc0_1 &tmp gIconBarCurIcon)
	(gUser canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= gIconBarCurIcon (gIconBar curIcon?))
	(gIconBar disable: 5 0 1 2 3 4 6 5)
	(gIconBar curIcon: gIconBarCurIcon)
	(if gPseudoMouse (gPseudoMouse stop:))
	(if (not (HaveMouse))
		(= global105 ((gUser curEvent?) x?))
		(= global106 ((gUser curEvent?) y?))
		(gGame setCursor: gWaitC)
		(SetCursor 310 180)
	else
		(gGame setCursor: gWaitC)
	)
)

(procedure (proc0_2)
	(gUser canControl: 1 canInput: 1)
	(gIconBar enable: 5 0 1 2 3 5)
	(if (gIconBar curInvIcon?) (gIconBar enable: 4))
	(if (proc819_5 15) (gIconBar enable: 6))
	(if (not (gIconBar curInvIcon?)) (gIconBar disable: 4))
	(if (not (HaveMouse))
		(gGame setCursor: ((gIconBar curIcon?) cursor?))
		(SetCursor global105 global106)
	else
		(gGame setCursor: ((gIconBar curIcon?) cursor?))
	)
)

(procedure (proc0_3)
	((= gIconBar IconBar)
		add:
			(icon0 cursor: travelC yourself:)
			(icon2 cursor: eyeC yourself:)
			(icon1 cursor: handC yourself:)
			(icon6 cursor: talkC yourself:)
			(icon4 cursor: invC yourself:)
			(icon5 cursor: arrowC yourself:)
			(icon3 cursor: bagC yourself:)
			(icon7 cursor: arrowC yourself:)
			(icon9 cursor: helpC yourself:)
		eachElementDo: #init
		eachElementDo: #highlightColor 0
		eachElementDo: #lowlightColor global216
		curIcon: icon0
		useIconItem: icon4
		helpIconItem: icon9
		disable:
	)
	(icon5 message: (if (HaveMouse) 3840 else 9))
)

(procedure (proc0_4 param1 param2)
	(if (not (proc819_5 param2))
		(gGame changeScore: param1)
		(ecoStatusLine doit:)
		(proc819_3 param2)
		(pointsSound play:)
	)
)

(procedure (proc0_5 param1)
	(gIconBar
		curIcon: (gIconBar at: 4)
		curInvIcon: (gInv at: param1)
	)
	((gIconBar at: 4) cursor: ((gInv at: param1) cursor?))
	(invC
		loop: ((gIconBar curInvIcon?) cursorLoop?)
		cel: ((gIconBar curInvIcon?) cursorCel?)
	)
	(if (gUser canInput:)
		((gIconBar at: 4)
			signal: (& ((gIconBar at: 4) signal?) $fffb)
		)
		(gGame setCursor: invC)
	else
		(gGame setCursor: gCursorNumber)
	)
)

(procedure (proc0_6 param1 &tmp [temp0 300] temp300)
	(cond 
		((< param1 100)
			(cond 
				((> param1 72) (= param1 (- param1 72)) (= temp300 2))
				((> param1 36) (= param1 (- param1 36)) (= temp300 1))
				(else (= temp300 0))
			)
			(EcoNarrator init: 1 0 temp300 param1 0 3)
		)
		((< param1 200)
			(cond 
				((> param1 172) (= param1 (- param1 172)) (= temp300 2))
				((> param1 136) (= param1 (- param1 136)) (= temp300 1))
				(else (= param1 (- param1 100)) (= temp300 0))
			)
			(EcoNarrator init: 2 0 temp300 param1 0 4)
		)
		((< param1 300)
			(cond 
				((> param1 272) (= param1 (- param1 272)) (= temp300 2))
				((> param1 236) (= param1 (- param1 236)) (= temp300 1))
				(else (= param1 (- param1 200)) (= temp300 0))
			)
			(EcoNarrator init: 3 0 temp300 param1 0 5)
		)
	)
)

(instance arrowC of Cursor
	(properties
		view 957
		cel 8
	)
)

(instance nonC of Cursor
	(properties
		view 957
		cel 9
	)
)

(instance eyeC of Cursor
	(properties
		view 957
	)
)

(instance travelC of Cursor
	(properties
		view 957
		cel 1
	)
)

(instance handC of Cursor
	(properties
		view 957
		cel 3
	)
)

(instance bagC of Cursor
	(properties
		view 957
		cel 4
	)
)

(instance talkC of Cursor
	(properties
		view 957
		cel 5
	)
)

(instance helpC of Cursor
	(properties
		view 957
		cel 6
	)
)

(instance waitC of Cursor
	(properties
		view 957
		cel 7
	)
)

(instance invC of Cursor
	(properties
		view 958
	)
)

(instance ego of Ego
	(properties
		sightAngle 90
		view 800
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 1 0 3)
			)
			(2
				((ScriptID 2 1) init: 2 0 0 1 1 0 1)
			)
			(4
				(EcoNarrator init: 1 0 0 2 0 3)
			)
			(6
				(EcoNarrator init: 1 0 0 54 0 3)
			)
			(44
				(switch theTheVerb
					(26
						(if (proc999_5 gNumber 380 381)
							(global2 notify:)
						else
							(EcoNarrator init: 2 0 0 51 0 4)
						)
					)
					(28
						(if (proc819_5 68)
							(proc819_4 68)
							(global2 notify: 68)
						else
							(EcoNarrator init: 1 0 0 55 0 3)
						)
					)
					(12
						(EcoNarrator init: 1 0 0 23 0 3)
					)
					(25
						((ScriptID 2 1) init: 2 0 0 74 1 0 1)
					)
					(else 
						(super doVerb: theVerb theTheVerb)
					)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (get param1 &tmp temp0 temp1)
		(cond 
			((== param1 32)
				(= temp0 (gInv at: 32))
				(switch global233
					(1
						(temp0 loop: 4 cel: 11 cursorCel: 8)
					)
					(2
						(temp0 loop: 6 cel: 1 cursorCel: 9)
					)
				)
			)
			((and (== param1 33) (== global232 3))
				((= temp1 (gInv at: 33)) loop: 2)
				(temp1 cel: 9)
				(temp1 cursorLoop: 0)
				(temp1 cursorCel: 2)
			)
		)
		(super get: param1 &rest)
		(proc0_5 param1)
	)
	
	(method (put param1 &tmp temp0)
		(super put: param1 &rest)
		(if (not (gIconBar curInvIcon?)) (gIconBar disable: 4))
		(gIconBar curIcon: (gIconBar at: 0) advanceCurIcon:)
	)
)

(class Delph of EcoActor
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
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
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
		illegalBits $8000
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
		talkScript 0
	)
)

(instance delph of Delph
	(properties)
	
	(method (doVerb theVerb param2 &tmp temp0)
		(asm
			pushi    8
			lsp      theVerb
			pushi    1
			pushi    4
			pushi    6
			pushi    2
			pushi    3
			pushi    7
			pushi    8
			calle    proc999_5,  16
			not     
			bnt      code_03d9
			lap      theVerb
			sat      temp0
			ldi      44
			sap      theVerb
code_03d9:
			lsp      theVerb
			dup     
			ldi      1
			eq?     
			bnt      code_0411
			pToa     lookStr
			bnt      code_03fe
			pushi    #init
			pushi    6
			lsg      global250
			pushi    0
			pushi    0
			pushi    #lookStr
			pushi    0
			self     4
			push    
			pushi    0
			lsg      gNumber
			class    EcoNarrator
			send     16
			jmp      code_0591
code_03fe:
			pushi    #init
			pushi    6
			pushi    1
			pushi    0
			pushi    0
			pushi    7
			pushi    0
			pushi    3
			class    EcoNarrator
			send     16
			jmp      code_0591
code_0411:
			dup     
			ldi      4
			eq?     
			bnt      code_042a
			pushi    #init
			pushi    6
			pushi    1
			pushi    0
			pushi    0
			pushi    8
			pushi    0
			pushi    3
			class    EcoNarrator
			send     16
			jmp      code_0591
code_042a:
			dup     
			ldi      6
			eq?     
			bnt      code_0446
			pushi    #init
			pushi    7
			pushi    1
			pushi    0
			pushi    0
			pushi    2
			pushi    1
			pushi    0
			pushi    1
			pushi    2
			pushi    2
			pushi    0
			callk    ScriptID,  4
			send     18
			jmp      code_0591
code_0446:
			dup     
			ldi      2
			eq?     
			bnt      code_0527
			pushi    #script
			pushi    0
			lag      global2
			send     4
			bnt      code_046a
			pushi    #init
			pushi    6
			pushi    1
			pushi    0
			pushi    0
			pushi    56
			pushi    0
			pushi    3
			class    EcoNarrator
			send     16
			jmp      code_0591
code_046a:
			pToa     talkScript
			bnt      code_0482
			pushi    1
			push    
			callk    IsObject,  2
			bnt      code_0482
			pushi    #setScript
			pushi    1
			pTos     talkScript
			lag      global2
			send     6
			jmp      code_0591
code_0482:
			pushi    1
			pushi    107
			calle    proc819_5,  2
			bnt      code_049f
			pushi    #setScript
			pushi    1
			pushi    2
			pushi    1
			pushi    0
			callk    ScriptID,  4
			push    
			lag      global2
			send     6
			jmp      code_0591
code_049f:
			pushi    1
			pushi    143
			calle    proc819_5,  2
			bnt      code_0509
			pushi    1
			pushi    334
			calle    proc819_5,  2
			not     
			bnt      code_0509
			pushi    #has
			pushi    1
			pushi    31
			lag      gEgo
			send     6
			bt       code_04cf
			pushi    1
			pushi    332
			calle    proc819_5,  2
code_04cf:
			not     
			bt       code_04eb
			pushi    #has
			pushi    1
			pushi    30
			lag      gEgo
			send     6
			bt       code_04e8
			pushi    1
			pushi    331
			calle    proc819_5,  2
code_04e8:
			not     
			bnt      code_0509
code_04eb:
			pushi    #init
			pushi    7
			pushi    1
			pushi    0
			pushi    0
			pushi    2
			pushi    79
			pushi    81
			callk    Random,  4
			push    
			pushi    1
			pushi    0
			pushi    1
			pushi    2
			pushi    2
			pushi    0
			callk    ScriptID,  4
			send     18
			jmp      code_0591
code_0509:
			pushi    #init
			pushi    7
			pushi    1
			pushi    0
			pushi    0
			pushi    2
			pushi    3
			pushi    5
			callk    Random,  4
			push    
			pushi    1
			pushi    0
			pushi    1
			pushi    2
			pushi    2
			pushi    0
			callk    ScriptID,  4
			send     18
			jmp      code_0591
code_0527:
			dup     
			ldi      44
			eq?     
			bnt      code_0584
			pushi    110
			pushi    7
			pushi    1
			pushi    0
			pushi    0
			lst      temp0
			dup     
			ldi      29
			eq?     
			bnt      code_0541
			ldi      85
			jmp      code_0575
code_0541:
			dup     
			ldi      18
			eq?     
			bnt      code_054b
			ldi      86
			jmp      code_0575
code_054b:
			dup     
			ldi      31
			eq?     
			bnt      code_0555
			ldi      87
			jmp      code_0575
code_0555:
			dup     
			ldi      12
			eq?     
			bnt      code_055f
			ldi      88
			jmp      code_0575
code_055f:
			dup     
			ldi      9
			eq?     
			bnt      code_0569
			ldi      89
			jmp      code_0575
code_0569:
			dup     
			ldi      10
			eq?     
			bnt      code_0573
			ldi      90
			jmp      code_0575
code_0573:
			ldi      91
code_0575:
			toss    
			push    
			pushi    1
			pushi    0
			pushi    1
			pushi    2
			pushi    2
			pushi    0
			callk    ScriptID,  4
			send     18
			jmp      code_0591
code_0584:
			pushi    #doVerb
			pushi    2
			lsp      theVerb
			lst      temp0
			&rest    param2
			super    Delph,  8
code_0591:
			toss    
			ret     
		)
	)
	
	(method (setHeading param1)
		(return
			(if (!= heading param1)
				(super setHeading: param1 &rest)
			else
				(return heading)
			)
		)
	)
)

(instance stopGroop of Grooper
	(properties)
	
	(method (doit)
		(if
			(and
				(IsObject (gEgo cycler?))
				((gEgo cycler?) isKindOf: StopWalk)
			)
			(gEgo view: ((gEgo cycler?) vStopped?))
		)
		(super doit: &rest)
	)
)

(instance longSong of Sound
	(properties)
)

(instance longSong2 of Sound
	(properties)
)

(instance soundEffects of Sound
	(properties)
	
	(method (check)
		(DoSound sndUPDATE_CUES self)
		(if (self signal?)
			(self prevSignal: (self signal?) signal: 0)
			(cond 
				((> (self loop?) 1)
					(self loop: (- (self loop?) 1))
					(DoSound sndPLAY self 0)
				)
				((IsObject client) (client cue: self))
			)
		)
	)
)

(instance pointsSound of Sound
	(properties
		flags $0001
		number 900
		priority 15
	)
)

(instance ecoKeyDownHandler of EventHandler
	(properties)
)

(instance ecoMouseDownHandler of EventHandler
	(properties)
)

(instance ecoDirectionHandler of EventHandler
	(properties)
)

(class eco of Game
	(properties
		script 0
		printLang 1
		_detailLevel 3
		panelObj 0
		panelSelector 0
	)
	
	(method (init &tmp temp0)
		(= global227 1)
		(= global90 3)
		(= global15 0)
		(= global16 725)
		(= gEcoWin ecoWin)
		(proc804_3)
		(= gDelph delph)
		(= gStopGroop stopGroop)
		(= global34 1)
		Smopper
		Polygon
		PolyPath
		EcoRoom
		IconBar
		(ScriptID 982)
		RandCycle
		(ScriptID 819)
		(super init:)
		(StrCpy @global42 {})
		(= gEcoDoVerbCode ecoDoVerbCode)
		(= gEcoFtrInit ecoFtrInit)
		(= gEcoApproachCode ecoApproachCode)
		((= gEcoKeyDownHandler ecoKeyDownHandler) add:)
		((= gEcoMouseDownHandler ecoMouseDownHandler) add:)
		((= gEcoDirectionHandler ecoDirectionHandler) add:)
		(= gPseudoMouse PseudoMouse)
		((= gEgo ego) setSpeed: global252)
		(self setCursor: gCursorNumber 1 304 172)
		(gUser canControl: 0 canInput: 0 alterEgo: gEgo)
		((= gLongSong longSong) owner: self init: flags: 1)
		((= gLongSong2 longSong2) owner: self init:)
		(= gSoundEffects soundEffects)
		(= global27 {x.yyy})
		(= gArrowC arrowC)
		(= gFont 4)
		(= global103 (DoSound sndGET_POLYPHONY))
		(= global102 (Graph grGET_COLOURS))
		(ecoWin
			color: gInnerBordColor
			back: gBack
			innerBordColor: gInnerBordColor
			midBordColor: gMidBordColor
			outerBordColor: global208
		)
		(proc0_3)
		(= gInv Inv)
		((ScriptID 5 0) init:)
		(= global104 (if (GameIsRestarting) 400 else 360))
		(self newRoom: 803)
	)
	
	(method (play)
		(= gCursorNumber (= gWaitC waitC))
		(super play: &rest)
	)
	
	(method (replay)
		(ecoStatusLine doit:)
		(if (gUser canControl:)
			(self setCursor: gCursorNumber)
		else
			(waitC init:)
		)
		(super replay:)
	)
	
	(method (startRoom param1)
		(if gPseudoMouse (gPseudoMouse stop:))
		(if
			(and
				(gLongSong2 number?)
				(== (gLongSong2 prevSignal?) -1)
			)
			(gLongSong2 number: 0)
		)
		((ScriptID 806) doit: param1)
		(if (== param1 320)
			(travelC cel: 2)
			(gGame setCursor: travelC)
		)
		(if (== param1 381)
			(travelC cel: 1)
			(gGame setCursor: travelC)
		)
		(super startRoom: param1)
		(if (proc999_5 param1 803 360)
			(ecoStatusLine disable:)
			(gIconBar disable:)
		else
			(ecoStatusLine enable:)
			(gIconBar enable:)
		)
	)
	
	(method (restart &tmp temp0 [temp1 30] [temp31 30] [temp61 30])
		(= temp0 (gGame setCursor: 999 1))
		(Message msgGET 0 1 0 0 9 @temp1)
		(Message msgGET 0 1 0 0 10 @temp31)
		(Message msgGET 0 1 0 0 8 @temp61)
		(if (& global90 $0002) (DoAudio 2 0 1 0 0 9))
		(if (proc821_1 @temp1 78 @temp31 1 78 @temp61 0)
			(DrawPic 901 dpOPEN_PIXELATION)
			(ecoStatusLine doit:)
			(super restart:)
		)
		(gGame setCursor: temp0 1)
	)
	
	(method (handleEvent pEvent &tmp pEventType pEventMessage)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return 1))
		(pEvent claimed: 1)
		(= pEventType (pEvent type?))
		(= pEventMessage (pEvent message?))
		(return
			(cond 
				(
					(and
						(== pEventType evKEYBOARD)
						(== pEventMessage KEY_CONTROL)
					)
					(gGame quitGame:)
				)
				(
					(and
						(== pEventType evKEYBOARD)
						(== pEventMessage KEY_F2)
					)
					(cond 
						((gGame masterVolume:) (gGame masterVolume: 0))
						((> global103 1) (gGame masterVolume: 15))
						(else (gGame masterVolume: 1))
					)
				)
				(
					(and
						(or (not (gUser controls?)) (& (icon7 signal?) $0004))
						(!= gNumber 345)
					)
					1
				)
				((== pEventType evKEYBOARD)
					(switch (pEvent message?)
						(KEY_TAB
							(if (not (& (icon5 signal?) $0004))
								(gInv showSelf: gEgo)
							)
						)
						(KEY_SHIFTTAB
							(if (not (& (icon5 signal?) $0004))
								(gInv showSelf: gEgo)
							)
						)
						(KEY_F1 (gGame showControls:))
						(KEY_F5 (gGame save:))
						(KEY_F7 (gGame restore:))
						(KEY_F9 (gGame restart:))
					)
				)
			)
		)
	)
	
	(method (setCursor cursorNumber param2 param3 param4 &tmp theGCursorNumber)
		(= theGCursorNumber gCursorNumber)
		(if argc
			(if (IsObject cursorNumber)
				((= gCursorNumber cursorNumber) init:)
			else
				(SetCursor (= gCursorNumber cursorNumber) 0 0)
			)
		)
		(if (and (> argc 1) (not param2)) (SetCursor 996 0 0))
		(if (> argc 2)
			(if (< param3 0) (= param3 0))
			(if (< param4 0) (= param4 0))
			(SetCursor param3 param4)
		)
		(return theGCursorNumber)
	)
	
	(method (quitGame &tmp temp0 [temp1 30] [temp31 30] [temp61 30])
		(= temp0 (gGame setCursor: 999 1))
		(Message msgGET 0 1 0 0 6 @temp1)
		(Message msgGET 0 1 0 0 7 @temp31)
		(Message msgGET 0 1 0 0 8 @temp61)
		(if (& global90 $0002) (DoAudio 2 0 1 0 0 6))
		(super
			quitGame: (proc821_1 @temp1 78 @temp31 1 78 @temp61 0)
		)
		(gGame setCursor: temp0 1)
	)
	
	(method (showControls)
		((ScriptID 822 0) init: show: dispose:)
	)
	
	(method (showAbout)
		((ScriptID 810 0) doit:)
	)
)

(instance ecoApproachCode of Code
	(properties)
	
	(method (doit param1)
		(switch param1
			(1 1)
			(2 2)
			(3 4)
			(4 8)
			(6 16)
			(else  -32768)
		)
	)
)

(instance soundReset of Code
	(properties)
	
	(method (doit param1)
		(if
		(and (== (param1 prevSignal?) -1) (param1 number?))
			(param1 number: 0)
		)
	)
)

(instance speedORama of Code
	(properties)
	
	(method (doit param1)
		(if argc
			(= global252 param1)
			(if (gUser canControl:) (gEgo setSpeed: global252))
		)
		(return global252)
	)
)

(instance icon0 of EcoIconItem
	(properties
		view 950
		loop 9
		cel 0
		type $5000
		message 3
		signal $0041
		maskView 950
		maskLoop 9
		maskCel 2
		noun 1
		helpVerb 46
		helpStr 15
	)
	
	(method (select &tmp temp0)
		(return
			(if (super select: &rest)
				(gIconBar hide:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon1 of EcoIconItem
	(properties
		view 950
		loop 1
		cel 0
		message 4
		signal $0041
		maskView 950
		maskLoop 1
		maskCel 2
		noun 1
		helpVerb 47
		helpStr 16
	)
)

(instance icon2 of EcoIconItem
	(properties
		view 950
		loop 2
		cel 0
		message 1
		signal $0041
		maskView 950
		maskLoop 2
		maskCel 2
		noun 1
		helpVerb 48
		helpStr 17
	)
)

(instance icon3 of EcoIconItem
	(properties
		view 950
		loop 3
		cel 2
		message 6
		signal $0045
		maskView 950
		maskLoop 3
		maskCel 3
		noun 1
		helpVerb 49
		helpStr 18
	)
	
	(method (show)
		(if (proc819_5 15)
			(self loop: 3 cel: 0 maskLoop: 3 maskCel: 3 helpStr: 18)
			(if (& (icon0 signal?) $0004)
				(gIconBar disable: 6)
			else
				(gIconBar enable: 6)
			)
		else
			(self loop: 3 cel: 2 maskLoop: 3 maskCel: 3 helpStr: 19)
			(gIconBar disable: self)
		)
		(super show: &rest)
	)
)

(instance icon4 of EcoIconItem
	(properties
		view 950
		loop 4
		cel 0
		signal $0041
		maskView 950
		maskLoop 4
		maskCel 2
		noun 1
		helpVerb 50
		helpStr 20
	)
	
	(method (show)
		(if (not (gIconBar curInvIcon?))
			(gIconBar disable: self)
		)
		(super show: &rest)
	)
)

(instance icon5 of EcoIconItem
	(properties
		view 950
		loop 5
		cel 0
		type $0000
		message 0
		signal $0043
		maskView 950
		maskLoop 5
		maskCel 2
		noun 1
		helpVerb 51
		helpStr 21
	)
	
	(method (select)
		(if (super select: &rest) (gInv showSelf: gEgo))
	)
)

(instance icon6 of EcoIconItem
	(properties
		view 950
		loop 6
		cel 0
		message 2
		signal $0041
		maskView 950
		maskLoop 6
		maskCel 2
		noun 1
		helpVerb 52
		helpStr 22
	)
)

(instance icon7 of EcoIconItem
	(properties
		view 950
		loop 7
		cel 0
		message 7
		signal $0043
		maskView 950
		maskLoop 7
		maskCel 2
		noun 1
		helpVerb 53
		helpStr 23
	)
	
	(method (select)
		(return
			(if (super select: &rest)
				(gIconBar hide:)
				(gGame showControls:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon9 of EcoIconItem
	(properties
		view 950
		loop 8
		cel 0
		message 8
		signal $0003
		maskView 950
		maskLoop 8
		maskCel 2
		noun 1
		helpVerb 54
		helpStr 24
	)
)

(instance ecoDoVerbCode of Code
	(properties)
	
	(method (doit param1 param2 &tmp temp0)
		(if (not (proc999_5 param1 1 4 6 2 3 7 8))
			(= temp0 param1)
			(= param1 44)
		)
		(switch param1
			(1
				(if
				(and (param2 facingMe: gEgo) (param2 lookStr?))
					(EcoNarrator
						init: global250 0 0 (param2 lookStr?) 0 gNumber
					)
				)
			)
			(6
				(EcoNarrator init: 2 0 0 (Random 21 24) 0 4)
			)
			(2
				(EcoNarrator init: 2 0 0 (Random 30 34) 0 4)
			)
			(4
				(if (and (== gNumber 380) (proc819_5 111))
					((ScriptID 2 1) init: 2 0 0 73 1 0 1)
				else
					(EcoNarrator init: 2 0 0 (Random 25 29) 0 4)
				)
			)
			(44
				(EcoNarrator init: 2 0 0 (Random 35 39) 0 4)
			)
		)
	)
)

(instance ecoFtrInit of Code
	(properties)
	
	(method (doit param1)
		(if (== (param1 sightAngle?) 26505)
			(param1 sightAngle: 90)
		)
		(if (== (param1 actions?) 26505) (param1 actions: 0))
	)
)

(instance ecoWin of EcoWindow
	(properties)
)

(instance ecoStatusLine of SL
	(properties)
	
	(method (doit &tmp temp0 [temp1 80])
		(Message msgGET 0 1 0 0 34 @temp1)
		(= temp0 (Memory memALLOC_CRIT 82))
		(Format temp0 @temp1 global15 global16)
		(DrawStatus (if state temp0 else 0) gColor gBack)
		(Memory memFREE temp0)
	)
)
