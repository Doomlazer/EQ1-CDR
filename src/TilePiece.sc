;;; Sierra Script 1.0 - (do not remove this comment)
(script# 140)
(include sci.sh)
(use Main)
(use n804)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use EcoDialog)
(use RTRandCycle)
(use Polygon)
(use ForwardCounter)
(use n958)
(use DPath)
(use Rev)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm140 0
	eyeFeature 1
	tridentDesign 2
	background 3
	dr 4
	oracleAppears 5
	HelpMePlease 6
	finishCitizens 8
	Oracle 9
	bottomEyeInset 10
	TalkWithOracle 11
	breakage 12
	oracle 13
	t1 14
	blankSpot 15
	closeOracle 16
	proc140_17 17
	proc140_18 18
	proc140_19 19
	proc140_20 20
	fireAskRiddles 21
)

(local
	local0
	[theTilePiece 12]
	local13
	local14
	local15
	local16
	gEgoOnMeCheck
	local18
	local19
	[local20 100]
	[local120 6] = [122 85 156 85 188 84]
	[local126 3]
	[local129 4] = [35 -22 52 -9]
	[local133 4] = [37 -9 60 48]
	[local137 4] = [21 -5 41 4]
	[local141 4] = [65 -23 88 -9]
	[local145 4] = [87 -23 108 3]
	[local149 4] = [64 -1 76 9]
	[local153 4] = [26 20 39 28]
	[local157 4] = [-15 -19 14]
	[local161 4] = [-1 25 13 34]
	[local165 4] = [-16 32 11 44]
	[local169 4] = [11 41 28 48]
)
(procedure (proc140_17 param1 param2 &tmp temp0 temp1 temp2)
	(if (& (t1 signal?) $0008)
		(= temp0 (= temp2 0))
		(= temp1 1)
		(while (< temp2 12)
			(if (> temp0 3) (= temp0 0) (++ temp1))
			([theTilePiece temp2]
				show:
				x: (+ param1 (* 31 temp0))
				y: (+ (- param2 24) (* 24 temp1))
				stopUpd:
			)
			(++ temp0)
			(++ temp2)
		)
	)
)

(procedure (proc140_18 &tmp temp0)
	(if (not (& (t1 signal?) $0008))
		(= temp0 0)
		(while (< temp0 12)
			([theTilePiece temp0] hide:)
			(++ temp0)
		)
		(Animate (gCast elements?) 0)
	)
)

(procedure (proc140_19 param1 &tmp t1X t1Y)
	(= t1X (t1 x?))
	(= t1Y (t1 y?))
	(return
		(cond 
			(
				(or
					(proc999_4
						(+ t1X [local129 0])
						(+ t1Y [local129 1])
						(+ t1X [local129 2])
						(+ t1Y [local129 3])
						param1
					)
					(proc999_4
						(+ t1X [local133 0])
						(+ t1Y [local133 1])
						(+ t1X [local133 2])
						(+ t1Y [local133 3])
						param1
					)
					(proc999_4
						(+ t1X [local137 0])
						(+ t1Y [local137 1])
						(+ t1X [local137 2])
						(+ t1Y [local137 3])
						param1
					)
				)
				(return 1)
			)
			(
				(or
					(proc999_4
						(+ t1X [local141 0])
						(+ t1Y [local141 1])
						(+ t1X [local141 2])
						(+ t1Y [local141 3])
						param1
					)
					(proc999_4
						(+ t1X [local145 0])
						(+ t1Y [local145 1])
						(+ t1X [local145 2])
						(+ t1Y [local145 3])
						param1
					)
				)
				(return 2)
			)
			(
				(or
					(proc999_4
						(+ t1X [local149 0])
						(+ t1Y [local149 1])
						(+ t1X [local149 2])
						(+ t1Y [local149 3])
						param1
					)
					(proc999_4
						(+ t1X [local153 0])
						(+ t1Y [local153 1])
						(+ t1X [local153 2])
						(+ t1Y [local153 3])
						param1
					)
				)
				(return 3)
			)
			(
				(proc999_4
					(+ t1X [local157 0])
					(+ t1Y [local157 1])
					(+ t1X [local157 2])
					(+ t1Y [local157 3])
					param1
				)
				(return 4)
			)
			(
				(or
					(proc999_4
						(+ t1X [local161 0])
						(+ t1Y [local161 1])
						(+ t1X [local161 2])
						(+ t1Y [local161 3])
						param1
					)
					(proc999_4
						(+ t1X [local165 0])
						(+ t1Y [local165 1])
						(+ t1X [local165 2])
						(+ t1Y [local165 3])
						param1
					)
					(proc999_4
						(+ t1X [local169 0])
						(+ t1Y [local169 1])
						(+ t1X [local169 2])
						(+ t1Y [local169 3])
						param1
					)
				)
				(return 5)
			)
			(else (return 0))
		)
	)
)

(procedure (proc140_20 param1 param2 &tmp temp0)
	(asm
		pushi    2
		pushi    65535
		pushi    10
		pushi    531
		pushi    1
		pushi    65535
		pushi    110
		pushi    4
		dup     
		pushi    0
		pushi    0
		pushi    57
		class    EcoNarrator
		send     26
		jmp      code_047f
		pushi    1
		pushi    9
		calle    proc819_5,  2
		bnt      code_040a
		pushi    #posn
		pushi    2
		pushi    65535
		pushi    10
		pushi    531
		pushi    1
		pushi    65535
		pushi    110
		pushi    4
		dup     
		pushi    0
		pushi    0
		pushi    12
		class    EcoNarrator
		send     26
		jmp      code_047f
code_040a:
		pushi    #posn
		pushi    2
		pushi    65535
		pushi    10
		pushi    531
		pushi    1
		pushi    65535
		pushi    110
		pushi    4
		dup     
		pushi    0
		pushi    0
		pushi    49
		class    EcoNarrator
		send     26
		jmp      code_047f
		dup     
		ldi      6
		eq?     
		bnt      code_0472
		pushi    1
		pushi    9
		calle    proc819_5,  2
		bnt      code_0455
		pushi    #posn
		pushi    2
		pushi    65535
		pushi    10
		pushi    531
		pushi    1
		pushi    65535
		pushi    110
		pushi    4
		dup     
		pushi    0
		pushi    0
		pushi    48
		class    EcoNarrator
		send     26
		jmp      code_047f
code_0455:
		pushi    #posn
		pushi    2
		pushi    65535
		pushi    10
		pushi    531
		pushi    1
		pushi    65535
		pushi    110
		pushi    4
		dup     
		pushi    0
		pushi    0
		pushi    47
		class    EcoNarrator
		send     26
		jmp      code_047f
code_0472:
		pushi    #doVerb
		pushi    2
		lsp      param1
		lst      temp0
		&rest    param2
		super    EcoView,  8
code_047f:
		toss    
		ret     
	)
)

(procedure (localproc_2756 &tmp temp0)
	(if (not (& (t1 signal?) $0008))
		(proc0_1)
		(= temp0 0)
		(while (< temp0 12)
			([theTilePiece temp0] hide:)
			(++ temp0)
		)
		(if (proc819_5 9) (mixedPic dispose:))
		(mosaicPuzzle dispose:)
		(if (gCast contains: gDelph) (gDelph hide:))
		(gEgo hide:)
		(eco doit:)
		(localproc_29b2 0)
		(if (== ((Inv at: 9) owner?) 140) (shell init:))
		(gEgo show:)
		(if (gCast contains: gDelph) (gDelph show:))
		(Animate (gCast elements?) 0)
		(if (gEgo z?) (gEgo y: (+ (gEgo y?) 80) z: 0))
		(proc0_2)
	)
)

(procedure (localproc_286d &tmp temp0)
	(= temp0 0)
	(while (< temp0 12)
		(= [gTheTilePieceCorrectPosn temp0]
			([theTilePiece temp0] correctPosn?)
		)
		(++ temp0)
	)
)

(procedure (localproc_288f &tmp temp0)
	(= temp0 0)
	(while (< temp0 12)
		(= [theTilePiece temp0]
			(gCast
				firstTrue: #perform restoreCode [gTheTilePieceCorrectPosn temp0]
			)
		)
		([theTilePiece temp0] node: (+ temp0 1))
		(++ temp0)
	)
)

(procedure (localproc_28c9 &tmp temp0 temp1 theTheTilePiece temp3 theTheTilePieceX theTheTilePieceY)
	(= temp0 0)
	(while (< temp0 12)
		(if
			(!=
				((= theTheTilePiece [theTilePiece temp0]) node?)
				([theTilePiece temp0] correctPosn?)
			)
			(= temp3
				(gCast firstTrue: #perform restoreCode (+ temp0 1))
			)
			(blankSpot swapNode: theTheTilePiece temp3 calibrate:)
			(= theTheTilePieceX (theTheTilePiece x?))
			(= theTheTilePieceY (theTheTilePiece y?))
			(theTheTilePiece x: (temp3 x?))
			(theTheTilePiece y: (temp3 y?))
			(temp3 x: theTheTilePieceX)
			(temp3 y: theTheTilePieceY)
			(theTheTilePiece forceUpd:)
			(= temp1 0)
			(while (< temp1 12)
				(if
				(!= temp1 (- ([theTilePiece temp1] correctPosn?) 1))
					(return 1)
					(break)
				)
				(++ temp1)
			)
		)
		(++ temp0)
	)
	(return 0)
)

(procedure (localproc_29b2 param1)
	(if (or param1 local15)
		(if (or (!= (global2 curPic?) 141) local15)
			(= local15 0)
			(global2 drawPic: 141 6)
			(if (not (proc819_5 9)) (mixedPic addToPic:))
		)
	else
		(global2 drawPic: 140 7)
		(if (not (proc819_5 9)) (mixedPic addToPic:))
	)
)

(procedure (localproc_2a1d)
	(if (not local18)
		(localproc_29b2 1)
		(ShellInset init:)
		(shell posn: 153 91 0 cel: 2 priority: 15 forceUpd:)
		(proc0_2)
		(gIconBar disable: 0)
	)
)

(procedure (localproc_2a5b)
	(proc0_1)
	(gEgo hide:)
	(Animate (gCast elements?) 0)
	(localproc_29b2 0)
	(ShellInset dispose:)
	(shell posn: 155 105 -30 cel: 0 priority: 12 forceUpd:)
	(gEgo show:)
	(UnLoad 128 147)
	(proc0_2)
)

(procedure (localproc_2ab6)
	(if (or (not (proc819_5 7)) (proc819_5 73))
		(if (== ((Inv at: 9) owner?) 140)
			(gCast delete: shell)
		)
		(if (gCast contains: gDelph) (gDelph hide:))
		(localproc_29b2 1)
		(if (not (proc819_5 9)) (mixedPic addToPic:))
		(topEyeInset addToPic:)
		(bottomEyeInset addToPic:)
		(dr view: 146 loop: 1 cel: 0 x: 156 y: 112 init:)
		(background init:)
		(eyeFeature init:)
		(tridentDesign init:)
		(if local14
			(Animate (gCast elements?) 0)
			(= local19 (Random 1 3))
			(global2 setScript: depressEye)
			(= local14 0)
		)
		(if local13 (= local13 0) (bottomEyeInset doVerb: 29))
	else
		(EcoNarrator init: 4 0 0 16)
	)
)

(procedure (localproc_2bb8)
	(if (gFeatures contains: eyeFeature)
		(tridentDesign dispose:)
		(eyeFeature dispose:)
	)
	(bottomEyeInset dispose:)
	(topEyeInset dispose:)
	(background dispose:)
	(if (gCast contains: gDelph)
		(gDelph show: setPri: 5 signal: 28691)
	)
	(if (gCast contains: breakage)
		(breakage addToPic:)
	else
		(dr addToPic:)
	)
)

(procedure (localproc_2c31 param1 &tmp temp0)
	(= temp0 local18)
	(if (= local18 param1)
		(if (not temp0) (= gEgoOnMeCheck (gEgo onMeCheck?)))
		(gEgo onMeCheck: 0 stopUpd:)
	else
		(gEgo onMeCheck: gEgoOnMeCheck startUpd:)
		(= gEgoOnMeCheck 0)
	)
)

(procedure (localproc_2c71 param1 param2 param3 param4 param5 param6 param7 &tmp [temp0 20])
	(Graph
		grDRAW_LINE
		param2
		param1
		param2
		param3
		gInnerBordColor
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		param2
		param3
		param4
		param3
		gInnerBordColor
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		param4
		param1
		param4
		param3
		gInnerBordColor
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		param2
		param1
		param4
		param1
		gInnerBordColor
		-1
		-1
	)
	(Graph
		grUPDATE_BOX
		(- param2 1)
		(- param1 1)
		(+ param4 1)
		(+ param3 1)
		1
	)
	(Message msgGET 140 4 0 1 (- param7 36) @temp0)
	(Display
		@temp0
		dsCOORD
		param5
		param6
		dsFONT
		300
		dsCOLOR
		gInnerBordColor
	)
)

(class TilePiece of EcoView
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
		view 143
		loop 0
		cel 0
		priority 15
		underBits 0
		signal $4010
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
		lookStr 0
		correctPosn 0
		blankTile 0
		node 0
	)
	
	(method (init param1)
		(= global250 4)
		(= global251 1)
		(super init: &rest)
		(= [theTilePiece local0] self)
		(self
			blankTile: param1
			node: (= local0 (+ local0 1))
			hide:
		)
	)
	
	(method (doVerb theVerb &tmp theTheVerb temp1)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(cond 
					((proc819_5 9) (EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 12))
					((and blankTile (self check:)) (self move:))
					(blankTile (EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 11))
					(else (EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 10))
				)
			)
			(1
				(if (proc819_5 9)
					(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 9)
				else
					(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 8)
				)
			)
			(44
				(cond 
					((== theTheVerb 18) (EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 57))
					((proc819_5 9) (EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 12))
					(else (EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 49))
				)
			)
			(6
				(if (proc819_5 9)
					(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 48)
				else
					(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 47)
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
	
	(method (check)
		(proc999_5
			node
			(blankTile nTile?)
			(blankTile sTile?)
			(blankTile eTile?)
			(blankTile wTile?)
		)
	)
	
	(method (move &tmp [temp0 2] theX theY)
		(= theX x)
		(= theY y)
		(= x (blankTile x?))
		(= y (blankTile y?))
		(blankTile x: theX)
		(blankTile y: theY)
		(self forceUpd:)
		(gSoundEffects number: 143 loop: 1 play:)
		(blankTile swapNode: self blankTile calibrate:)
		(if (self checkPosn:)
			(Animate (gCast elements?) 0)
			(EcoNarrator
				posn: -1 10
				talkWidth: -1
				init: 4 0 0 27 self
			)
		)
	)
	
	(method (checkPosn &tmp temp0)
		(= temp0 0)
		(while (< temp0 12)
			(if
				(!=
					([theTilePiece temp0] node?)
					([theTilePiece temp0] correctPosn?)
				)
				(return 0)
				(break)
			)
			(++ temp0)
		)
		(return 1)
	)
	
	(method (cue)
		(proc819_3 9)
		(proc0_4 15 258)
		(if (proc819_5 30) (= local15 1))
		(localproc_2756)
		(if (proc819_5 30) (= local13 1) (localproc_2ab6))
	)
)

(class BlankSpot of TilePiece
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
		view 143
		loop 0
		cel 0
		priority 15
		underBits 0
		signal $4010
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
		lookStr 0
		correctPosn 0
		blankTile 0
		node 0
		nTile 0
		sTile 0
		wTile 0
		eTile 0
	)
	
	(method (calibrate)
		(= nTile (if (< node 5) 0 else (- node 4)))
		(= sTile (if (> node 8) 0 else (+ node 4)))
		(= eTile
			(if (proc999_5 node 4 8 12) 0 else (+ node 1))
		)
		(= wTile (if (proc999_5 node 1 5 9) 0 else (- node 1)))
	)
	
	(method (swapNode theTheTilePiece_2 theTheTilePiece &tmp theTheTilePiece_2Node theTheTilePieceNode)
		(= theTheTilePiece_2Node (theTheTilePiece_2 node?))
		(= theTheTilePieceNode (theTheTilePiece node?))
		(= [theTilePiece (- theTheTilePiece_2Node 1)]
			theTheTilePiece
		)
		(= [theTilePiece (- theTheTilePieceNode 1)]
			theTheTilePiece_2
		)
		(theTheTilePiece_2 node: theTheTilePieceNode)
		(theTheTilePiece node: theTheTilePiece_2Node)
	)
)

(instance rm140 of EcoRoom
	(properties
		picture 140
		style $000a
		horizon 15
		south 120
		lookStr 17
	)
	
	(method (init)
		(proc958_0 128 140 142)
		(plant1 setCycle: Fwd init:)
		(if
			(and
				(not (gEgo has: 9))
				(!= ((Inv at: 9) owner?) 120)
			)
			(shell init: stopUpd:)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 92 189 92 177 159 177 159 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 174 132 174 170 137 170 137 132
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 189 0 -10 11 -10 11 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 303 -10 319 -10 319 189 303 189
					yourself:
				)
		)
		(gFeatures
			add: MosaicWall OracleWall carvings columnPed pots stairsF skyF floorF
			eachElementDo: #init
		)
		(super init:)
		(UnLoad 129 120)
		(if (not (proc819_5 9)) (mixedPic addToPic:))
		(proc819_6)
		(gEgo init: posn: 182 215 ignoreHorizon: 1)
		(t10 init: blankSpot)
		(t7 init: blankSpot)
		(t5 init: blankSpot)
		(t9 init: blankSpot)
		(t4 init: blankSpot)
		(t2 init: blankSpot)
		(t8 init: blankSpot)
		(t6 init: blankSpot)
		(t1 init: blankSpot)
		(blankSpot init: 0)
		(t3 init: blankSpot)
		(t11 init: blankSpot)
		(if gTheTilePieceCorrectPosn (localproc_288f))
		(blankSpot calibrate:)
		(self setRegions: 51)
		(if (gEgo has: 2)
			(self setScript: enterWithMask)
		else
			(self setScript: enterScript)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			(
			(and (gEgo has: 2) (== ((User alterEgo?) edgeHit?) 3)) (global2 setScript: getProphesy))
			((== (gEgo edgeHit?) 1) (self setScript: NoExit))
		)
		(if
			(and
				(GameIsRestarting)
				(== local18 1)
				(not (proc819_5 9))
			)
			(localproc_2c71 82 154 140 167 98 156 61)
		)
		(super doit:)
		(if
			(and
				(!= (gLongSong number?) 140)
				(== (gLongSong prevSignal?) -1)
			)
			(gLongSong number: 140 loop: -1 play:)
		)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (gCast contains: oracle)
					(EcoNarrator init: 4 0 0 26)
				else
					(EcoNarrator init: 4 0 0 17)
				)
			)
			(44
				(switch theTheVerb
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
	
	(method (newRoom newRoomNumber)
		(localproc_286d)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 1))
			(1
				(gEgo setMotion: MoveTo 182 181 self)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance enterWithMask of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 1))
			(1
				(proc819_7)
				(gDelph
					talkScript: needToSeeOracle
					posn: 79 189 0
					init:
					setStep: 8 4
					setMotion: DPath 79 130 144 94 self
				)
				(gEgo setMotion: MoveTo 182 181 self)
			)
			(2 0)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance needToSeeOracle of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 0) init: 3 0 0 3 1 self)
			)
			(1 (proc0_2) (self dispose:))
		)
	)
)

(instance NoExit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(EcoNarrator init: 4 0 0 25 self)
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x?) (+ (global2 horizon?) 5) self
				)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance TalkWithOracle of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc0_4 2 257)
				(cond 
					((not (proc819_3 29)) (= cycles 1))
					((proc819_5 4)
						(if gNewEventHandler (Oracle dispose:))
						(global2 setScript: finishCitizens)
					)
					(else (= state 2) (= cycles 1))
				)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 1 1 self)
			)
			(2
				(Oracle init: 2 0 0 2 0 self)
			)
			(3
				(if (proc819_5 9)
					(if gNewEventHandler (Oracle dispose:))
					(global2 setScript: (ScriptID 142 0))
				else
					(proc819_3 30)
					(Oracle init: 2 0 0 3 1 self)
				)
			)
			(4
				(if (proc819_5 30)
					(self setScript: closeOracle self)
				else
					(= state 5)
					(= cycles 1)
				)
			)
			(5
				(= local15 1)
				(MosaicWall doVerb: 4)
				(= cycles 1)
			)
			(6 (proc0_2) (self dispose:))
		)
	)
)

(instance closeOracle of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(if (gCast contains: oracle)
					(self setScript: oracleDisappears self)
				else
					(self changeState: 3)
				)
			)
			(1
				(dr show: setMotion: MoveTo 156 112 self)
			)
			(2
				(dr cel: 0)
				(gSoundEffects number: 165 loop: 1 flags: 0 play: self)
			)
			(3
				(gEgo hide:)
				(localproc_2bb8)
				(gFeatures delete: dr topEyeInset bottomEyeInset)
				(= cycles 1)
			)
			(4
				(if (gAddToPics contains: breakage)
					(dr dispose:)
					(breakage dispose:)
					(breakage signal: 17)
				else
					(dr dispose:)
				)
				(= cycles 2)
			)
			(5
				(if register (= register 0) (localproc_29b2 0))
				(if (== ((Inv at: 9) owner?) 140) (shell init:))
				(gEgo show:)
				(= cycles 2)
			)
			(6 (proc0_2) (self dispose:))
		)
	)
)

(instance finishCitizens of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(Oracle init: 2 0 0 17 1 self)
			)
			(2
				(proc0_2)
				(gIconBar disable: 0)
				(= seconds 10)
			)
			(3
				(self setScript: closeOracle self 1)
			)
			(4 (proc0_2) (self dispose:))
		)
	)
)

(instance showAnyObject of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(Oracle init: 2 0 0 18 1 self)
			)
			(1 (= seconds 4))
			(2
				(self setScript: closeOracle self 1)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance giveMask of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gDelph talkScript: 0)
				(proc0_4 10 262)
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 29 self)
				(gEgo put: 2 140)
			)
			(1
				(Oracle init: 2 0 0 19 1 self)
			)
			(2
				(EcoNarrator init: 2 0 0 20 self 140)
			)
			(3
				((ScriptID 2 1) init: 1 0 0 7 1 self)
			)
			(4
				(Oracle init: 2 0 0 21 0 self)
			)
			(5
				(Oracle init: 2 0 0 22 1 self)
			)
			(6
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 5 self)
				(OracleWall approachVerbs: 26505)
				(carvings approachVerbs: 26505)
				(proc819_3 7)
				(gEgo get: 25)
			)
			(7
				(self setScript: closeOracle self 1)
			)
			(8 (= cycles 4))
			(9
				((ScriptID 2 0) init: 3 0 0 1 1 self)
			)
			(10
				(gDelph setMotion: MoveTo 79 130 self)
			)
			(11
				(gDelph setMotion: MoveTo 79 260 self)
			)
			(12 (proc0_2) (self dispose:))
		)
	)
)

(instance oracleAppears of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rippleBg
					init:
					view: 151
					loop: 2
					cel: 0
					setCycle: CT 7 1 self
				)
				(gSoundEffects number: 146 loop: 1 play:)
				(oracle
					init:
					view: 149
					loop: 0
					cel: 0
					setCycle: End oracle
				)
			)
			(1
				(background setLoop: 1 cel: 0 setCycle: Fwd)
				(rippleBg cel: 8 setCycle: ForwardCounter 2 self)
			)
			(2
				(rippleBg hide: setCycle: 0 stopUpd:)
				(= cycles 1)
			)
			(3
				(oracle
					view: 142
					loop: 4
					cel: 0
					posn: 131 79
					setCycle: Fwd
				)
				(background setCycle: End self)
			)
			(4
				(background setLoop: 0 cel: 0 setCycle: 0 stopUpd:)
				(gLongSong number: 141 loop: -1 flags: 1 play:)
				(= seconds 2)
			)
			(5 (self dispose:))
		)
	)
)

(instance oracleDisappears of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local16 1)
				(rippleBg show: setLoop: 2 cel: 0 setCycle: End self)
				(oracle
					view: 149
					loop: 1
					cel: 7
					posn: 163 98
					setCycle: Rev
				)
				(background view: 151 loop: 1 cel: 7 setCycle: Rev)
			)
			(1
				(gLongSong fade:)
				(gSoundEffects number: 146 loop: 1 play:)
				(oracle
					setLoop: 0
					cel: 14
					posn: 163 98
					setCycle: Beg oracle
				)
				(rippleBg cel: 0 setCycle: End self)
			)
			(2
				(background
					view: 151
					loop: 3
					cel: 5
					setCycle: CT 2 -1 self
				)
			)
			(3
				(rippleBg dispose:)
				(background setCycle: Beg self)
			)
			(4 (= seconds 2))
			(5 (self dispose:))
		)
	)
)

(instance getProphesy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 0) init: 3 0 0 2 1 self)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x?) 184 self)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance HelpMePlease of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 2))
			(1
				(Oracle init: 2 0 0 24 1 self)
			)
			(2
				(global2 setScript: closeOracle 0 1)
			)
		)
	)
)

(instance plant1 of EcoProp
	(properties
		x 220
		y 189
		onMeCheck $0000
		view 140
		priority 14
		signal $4010
		cycleSpeed 13
		detailLevel 2
	)
)

(instance ShellInset of EcoView
	(properties
		x 154
		y 110
		view 147
		priority 14
		signal $0010
		lookStr 7
	)
	
	(method (init)
		(if (not z) (proc804_8 self))
		(super init: &rest)
		(gEcoKeyDownHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
		(localproc_2c31 2)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(localproc_2c31 0)
		(super dispose: &rest)
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
			(localproc_2a5b)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (== ((Inv at: 9) owner?) 140)
					(EcoNarrator store: 31)
				)
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 7)
			)
			(44
				(switch theTheVerb
					(18
						(shell posn: 153 91 0 cel: 2 init: setPri: 15 stopUpd:)
						(gEgo put: 9 140)
						(Animate (gCast elements?) 0)
						(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 56)
					)
					(else 
						(super doVerb: theVerb theTheVerb &rest)
					)
				)
			)
			(4 (EcoNarrator init: 4 0 0 33))
			(6
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 46)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance shell of EcoView
	(properties
		x 155
		y 105
		z -30
		view 140
		loop 2
		priority 12
		signal $4011
	)
	
	(method (dispose)
		(super dispose:)
		(if (== gNumber gNewRoomNumber) (localproc_2a5b))
	)
	
	(method (doVerb theVerb)
		(if (or (not local18) (== local18 2))
			(switch theVerb
				(1
					(if (not cel)
						(localproc_2a1d)
						(Animate (gCast elements?) 0)
						(EcoNarrator
							store: 31
							posn: 45 142
							talkWidth: 224
							init: 4 0 0 32
						)
					else
						(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 6)
					)
				)
				(4
					(if (not cel)
						(localproc_2a1d)
					else
						(global2 setScript: getConchShell)
					)
				)
				(6
					(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 45)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance getConchShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator
					posn: 45 142
					talkWidth: 224
					init: 4 0 0 1 self
				)
				(proc0_4 2 256)
				(gEgo get: 9)
			)
			(1
				(shell dispose:)
				(self dispose:)
			)
		)
	)
)

(instance fireAskRiddles of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (global2 script?) (-- state))
				(= cycles 1)
			)
			(1
				(global2 setScript: (ScriptID 142 0) self)
			)
			(2 (= cycles 2))
			(3 (self dispose:))
		)
	)
)

(instance lalala of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 3))
			(1 (self dispose:))
		)
	)
)

(instance columnPed of EcoFeature
	(properties
		onMeCheck $0100
		lookStr 7
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(localproc_2a1d)
				(Animate (gCast elements?) 0)
				(if (== ((Inv at: 9) owner?) 140)
					(EcoNarrator store: 31)
				)
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 32)
			)
			(44
				(if (== theTheVerb 18)
					(shell posn: 155 105 -30 cel: 0 init: setPri: 12 stopUpd:)
					(gEgo put: 9 140)
					(Animate (gCast elements?) 0)
					(EcoNarrator init: 4 0 0 56)
				else
					(super doVerb: theVerb theTheVerb &rest)
				)
			)
			(4
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 33)
			)
			(6
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 46)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance mixedPic of EcoView
	(properties
		x 62
		y 102
		onMeCheck $0000
		view 156
		signal $4011
	)
)

(instance MosaicWall of EcoFeature
	(properties
		x 69
		y 97
		onMeCheck $0002
		approachX 105
		approachY 105
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 4)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (or (not local18) (== local18 1))
			(cond 
				((proc999_5 theVerb 1 4)
					(if (== ((Inv at: 9) owner?) 140)
						(gCast delete: shell)
					)
					(localproc_29b2 1)
					(mosaicPuzzle addToPic:)
					(proc140_17 106 80)
					(gEgo y: (- (gEgo y?) 80) z: -80)
					(Animate (gCast elements?) 0)
					(if (not (proc819_5 9))
						(localproc_2c71 82 154 140 167 98 156 61)
					)
					(proc0_2)
					(gIconBar disable: 0 3 4 6 5)
					(t1 doVerb: 1)
				)
				((== theVerb 6)
					(if (proc819_5 9)
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 48)
					else
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 47)
					)
				)
				((== theVerb 44)
					(if (proc819_5 9)
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 12)
					else
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 49)
					)
				)
				(else (super doVerb: theVerb temp0 &rest))
			)
		)
	)
)

(instance mosaicPuzzle of EcoView
	(properties
		x 144
		y 28
		view 148
		priority 14
		signal $0011
	)
	
	(method (init)
		(super init:)
		(gEcoKeyDownHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
		(gIconBar curIcon: (gIconBar at: 2))
		(gGame setCursor: ((gIconBar curIcon?) cursor?))
		(localproc_2c31 1)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(localproc_2c31 0)
		(super dispose: &rest)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(cond 
			(
				(and
					(!= (pEvent type?) evVERB)
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
					(not (pEvent modifiers?))
				)
				(if
					(and
						(not (proc819_5 9))
						(proc999_4 82 154 140 167 pEvent)
					)
					(if
					(and (not (localproc_28c9)) (not (proc819_5 9)))
						(Animate (gCast elements?) 0)
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 27 t1)
					)
				else
					(localproc_2756)
				)
				(pEvent claimed: 1)
			)
			(
				(and
					(proc819_5 9)
					(== (gIconBar curIcon?) (gIconBar at: 1))
					(not (& (pEvent type?) $000a))
					(= temp0 (proc140_19 pEvent))
				)
				(switch temp0
					(1
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 18)
					)
					(2
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 19)
					)
					(3
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 21)
					)
					(4
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 22)
					)
					(5
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 20)
					)
				)
				(pEvent claimed: 1)
			)
			(else (super handleEvent: pEvent))
		)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (t1 doVerb: 1))
			(44
				(if (== theTheVerb 18)
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 57)
				else
					(super doVerb: theVerb theTheVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance t1 of TilePiece
	(properties
		loop 1
		correctPosn 1
	)
)

(instance t2 of TilePiece
	(properties
		loop 1
		cel 1
		correctPosn 2
	)
)

(instance t3 of TilePiece
	(properties
		loop 1
		cel 2
		correctPosn 3
	)
)

(instance t4 of TilePiece
	(properties
		loop 1
		cel 3
		correctPosn 4
	)
)

(instance t5 of TilePiece
	(properties
		loop 1
		cel 4
		correctPosn 5
	)
)

(instance t6 of TilePiece
	(properties
		loop 1
		cel 5
		correctPosn 6
	)
)

(instance t7 of TilePiece
	(properties
		loop 1
		cel 6
		correctPosn 7
	)
)

(instance t8 of TilePiece
	(properties
		loop 1
		cel 7
		correctPosn 8
	)
)

(instance t9 of TilePiece
	(properties
		loop 1
		cel 8
		correctPosn 9
	)
)

(instance t10 of TilePiece
	(properties
		loop 1
		cel 9
		correctPosn 10
	)
)

(instance t11 of TilePiece
	(properties
		loop 1
		cel 10
		correctPosn 11
	)
)

(instance blankSpot of BlankSpot
	(properties
		loop 2
		correctPosn 12
	)
)

(instance carvings of EcoFeature
	(properties
		x 242
		y 89
		onMeCheck $0008
		approachX 198
		approachY 97
		lookStr 13
	)
	
	(method (init)
		(super init: &rest)
		(if (not (proc819_5 7)) (self approachVerbs: 9))
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(44
				(switch theTheVerb
					(29
						(EcoNarrator init: 4 0 0 51)
					)
					(18
						(EcoNarrator init: 4 0 0 58)
					)
					(else 
						(EcoNarrator init: 4 0 0 24)
					)
				)
			)
			(4 (EcoNarrator init: 4 0 0 14))
			(6 (EcoNarrator init: 4 0 0 50))
			(2 (EcoNarrator init: 4 0 0 54))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance OracleWall of EcoFeature
	(properties
		x 242
		y 89
		onMeCheck $0040
		approachX 198
		approachY 97
	)
	
	(method (init)
		(super init: &rest)
		(if (not (proc819_5 7)) (self approachVerbs: 9 4 1))
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(44
				(switch theTheVerb
					(29
						(= local13 1)
						(localproc_2ab6)
					)
					(else 
						(EcoNarrator init: 4 0 0 23)
					)
				)
			)
			(1
				(localproc_2ab6)
				(Animate (gCast elements?) 0)
				(if (or (not (proc819_5 7)) (proc819_5 73))
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 28)
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 store: 28)
				)
			)
			(4
				(= local14 1)
				(localproc_2ab6)
			)
			(2 (EcoNarrator init: 4 0 0 54))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance topEyeInset of EcoView
	(properties
		x 143
		y 67
		view 146
		priority 14
		signal $4011
	)
	
	(method (doVerb)
		(bottomEyeInset doVerb: &rest)
	)
)

(instance bottomEyeInset of EcoView
	(properties
		x 151
		y 66
		z -87
		view 146
		cel 1
		priority 13
		signal $4011
	)
	
	(method (init)
		(super init:)
		(localproc_2c31 3)
		(if (gCast contains: gDelph)
			(gDelph
				talkScript: 0
				stopUpd:
				y: (- (gDelph y?) 1000)
				z: (- (gDelph z?) 1000)
				onMeCheck: 0
			)
		)
		(gEcoKeyDownHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
		(if (not (proc819_5 255)) (breakage init:))
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(if (gCast contains: gDelph)
			(gDelph
				y: (+ (gDelph y?) 1000)
				z: (+ (gDelph z?) 1000)
				onMeCheck: 26505
			)
		)
		(localproc_2c31 0)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (global2 script?))
				(not (gCast contains: oracle))
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
				(!= (pEvent type?) evVERB)
				(not (& (pEvent type?) $000a))
				(not
					(proc999_4
						(topEyeInset nsLeft?)
						(topEyeInset nsTop?)
						nsRight
						nsBottom
						pEvent
					)
				)
				(not (pEvent modifiers?))
			)
			(pEvent claimed: 1)
			(global2 setScript: closeOracle 0 1)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (gCast contains: oracle)
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 26)
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 28)
				)
			)
			(44
				(switch theTheVerb
					(29
						(cond 
							((and (proc819_5 7) (not (proc819_5 73))) (EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 16))
							((not (gCast contains: oracle)) (global2 setScript: (ScriptID 141 0)))
							(else (EcoNarrator init: 4 0 0 59))
						)
					)
					(18
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 58)
					)
					(else 
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 23)
					)
				)
			)
			(6
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 50)
			)
			(2
				(if (not (gCast contains: oracle))
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 54)
				else
					(super doVerb: theVerb theTheVerb &rest)
				)
			)
			(4
				(if (gCast contains: oracle)
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 55)
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 28)
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance dr of EcoActor
	(properties)
	
	(method (init)
		(self
			view: 146
			loop: 1
			cel: 0 x 156
			y: 112
			illegalBits: 0
			priority: 13
			signal: 16401
		)
		(super init: &rest)
	)
	
	(method (doVerb)
		(bottomEyeInset doVerb: &rest)
	)
)

(instance breakage of EcoProp
	(properties
		x 156
		y 121
		view 155
		priority 14
		signal $0011
	)
	
	(method (init)
		(if (not z) (proc804_8 self))
		(super init: &rest)
	)
	
	(method (doVerb &tmp tmpScr)
		(= tmpScr (ScriptID 140 10))
		(tmpScr doVerb: &rest)
	)
)

(instance background of EcoProp
	(properties
		x 156
		y 91
		view 151
		priority 9
		signal $4011
	)
	
	(method (init)
		(if (not z) (proc804_8 self))
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 26)
		else
			(bottomEyeInset doVerb: theVerb &rest)
		)
	)
)

(instance rippleBg of EcoProp
	(properties
		x 156
		y 92
		view 151
		loop 1
		priority 10
		signal $4010
		cycleSpeed 12
	)
)

(instance oracle of EcoProp
	(properties
		x 163
		y 98
		z 7
		view 143
		priority 11
		signal $5010
		lookStr 26
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 15)
			)
			(2
				(global2 setScript: TalkWithOracle)
			)
			(44
				(if (proc819_5 4)
					(switch theTheVerb
						(11
							(global2 setScript: giveMask)
						)
						(else 
							(global2 setScript: showAnyObject)
						)
					)
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 41)
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
	
	(method (cue)
		(if local16
			(= local16 0)
			(self dispose:)
		else
			(self loop: 1 cel: 0 setCycle: Fwd)
		)
	)
)

(instance eyeFeature of EcoFeature
	(properties
		x 163
		y 113
		z 28
		sightAngle 0
		lookStr 60
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(global2 setScript: depressEye)
			)
			(44
				(if (== theTheVerb 29)
					(global2 setScript: (ScriptID 141 0))
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 23)
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(cond 
			(
				(or
					(and (proc999_4 112 81 132 89 param1) (= local19 1))
					(and (proc999_4 145 81 165 89 param1) (= local19 2))
				)
			)
			((proc999_4 177 80 197 88 param1) (= local19 3))
		)
	)
)

(instance eye of EcoView
	(properties
		view 141
		loop 1
		priority 15
		signal $4010
	)
)

(instance depressEye of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(eye
					cel: local19
					init:
					x: [local120 (= local19 (* (- local19 1) 2))]
					y:
						[local120 (+
							(= [local126 (- local19 1)]
								(+ [local126 (- local19 1)] 1)
							)
							1
						)]
				)
				(gGame setCursor: ((gIconBar at: 2) cursor?))
				(SetCursor (eye x?) (eye y?))
				(= cycles 10)
			)
			(1
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 2 self)
			)
			(2
				(= local19 0)
				(eye dispose:)
				(= cycles 2)
			)
			(3
				(if
					(and
						(> [local126 0] 0)
						(> [local126 1] 0)
						(> [local126 2] 0)
					)
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 3 self)
				else
					(= ticks 10)
				)
			)
			(4
				(proc0_2)
				(gIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance fourColumns of EcoFeature
	(properties
		onMeCheck $0010
		lookStr 62
	)
)

(instance pots of EcoFeature
	(properties
		onMeCheck $0200
		lookStr 34
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 4 0 0 35))
			(6 (EcoNarrator init: 4 0 0 44))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stairsF of EcoFeature
	(properties
		onMeCheck $1000
		lookStr 39
	)
	
	(method (doVerb theVerb)
		(= x ((User curEvent?) x?))
		(= y ((User curEvent?) y?))
		(switch theVerb
			(4 (EcoNarrator init: 4 0 0 40))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skyF of EcoFeature
	(properties
		onMeCheck $4000
		lookStr 38
	)
	
	(method (doVerb theVerb)
		(= x ((User curEvent?) x?))
		(= y ((User curEvent?) y?))
		(switch theVerb
			(4 (EcoNarrator init: 4 0 0 25))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floorF of EcoFeature
	(properties
		onMeCheck $0080
		lookStr 36
	)
	
	(method (doVerb theVerb)
		(= x ((User curEvent?) x?))
		(= y ((User curEvent?) y?))
		(switch theVerb
			(4 (EcoNarrator init: 4 0 0 37))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tridentDesign of EcoFeature
	(properties
		y 119
		nsTop 98
		nsLeft 112
		nsBottom 119
		nsRight 193
		lookStr 53
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 53)
			)
			(else 
				(bottomEyeInset doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance Oracle of EcoTalker
	(properties
		nsTop 76
		nsLeft 135
		view 142
		charNum 1
		keepWindow 1
	)
	
	(method (init)
		(oracle setPri: 0)
		(super init: oracleBust oracleEye oracleMouth &rest)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(oracle setPri: 11 setCycle: Fwd)
	)
	
	(method (display)
		(proc821_1 &rest 64 -1 10 111 77 name)
	)
)

(instance oracleBust of EcoProp
	(properties
		view 142
		priority 14
		signal $4011
	)
)

(instance oracleEye of EcoProp
	(properties
		nsTop 12
		nsLeft 30
		view 142
		loop 2
		cycleSpeed 30
	)
)

(instance oracleMouth of EcoProp
	(properties
		nsTop 13
		nsLeft 35
		view 142
		loop 1
		cycleSpeed 10
	)
)

(instance restoreCode of Code
	(properties)
	
	(method (doit param1 param2)
		(return
			(if
				(or
					(param1 isKindOf: TilePiece)
					(param1 isKindOf: BlankSpot)
				)
				(== param2 (param1 correctPosn?))
			else
				0
			)
		)
	)
)
