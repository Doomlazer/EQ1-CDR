;;; Sierra Script 1.0 - (do not remove this comment)
(script# 160)
(include sci.sh)
(use Main)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use DPath)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm160 0
)

(local
	local0
	local1
	local2 =  33
	[local3 500]
)
(procedure (localproc_2b8c &tmp temp0)
	(while (not (tmpList isEmpty:))
		(= temp0 (Random 0 (- (tmpList size?) 1)))
		(columnList add: (tmpList at: temp0))
		(tmpList delete: (tmpList at: temp0))
	)
	(tmpList dispose:)
)

(procedure (localproc_2bde &tmp temp0 temp1 temp2)
	(= temp0 0)
	(while (< temp0 (columnList size?))
		(= [global175 temp0]
			(+
				(* ((= temp2 (columnList at: temp0)) placeHolder?) 10)
				(temp2 cel?)
			)
		)
		(++ temp0)
	)
)

(procedure (localproc_2c1b &tmp temp0 temp1)
	(= temp0 0)
	(while (< temp0 (tmpList size?))
		((tmpList at: (= temp1 (/ [global175 temp0] 10)))
			cel: (mod [global175 temp0] 10)
		)
		(columnList add: (tmpList at: temp1))
		(++ temp0)
	)
	(tmpList release: dispose:)
)

(procedure (localproc_2c71 &tmp temp0)
	(= temp0 1)
	(cond 
		(
			(and
				(gCast contains: goldMask)
				(== (goldMask script?) whoDares)
				(proc819_5 4)
			)
			(whoDares dispose:)
			(proc0_4 2 265)
			(global2 setScript: senatorSpeech)
		)
		((not (proc819_5 4)) (EcoNarrator init: 1 0 0 3))
		((and (not (proc819_5 2)) (proc819_5 3)) (EcoNarrator init: 1 0 0 15))
		(else (= temp0 0))
	)
	(return temp0)
)

(procedure (localproc_2d0c &tmp temp0 temp1)
	(= temp0 0)
	(while
		(and
			(< temp0 (columnList size?))
			(not ((= temp1 (columnList at: temp0)) cel?))
		)
		(temp1 locked: 1)
		(++ temp0)
	)
)

(class Column of EcoView
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
		approachX 79
		approachY 145
		approachDist 0
		_approachVerbs 0
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0101
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
		endCel 2
		placeHolder 0
		locked 0
		caller 0
		aligned 0
	)
	
	(method (init param1)
		(super init: &rest)
		(tmpList add: self)
		(self placeHolder: param1 setPri: 0 cel: (Random 1 2))
	)
	
	(method (dispose)
		(columnList delete: self)
		(super dispose:)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((proc819_5 2) (EcoNarrator init: 1 0 0 32))
					(locked (EcoNarrator init: 1 0 0 36))
					((proc819_5 3) (global2 setScript: doRiddle))
					(else (EcoNarrator init: 1 0 0 4))
				)
			)
			(4
				(cond 
					((not (proc819_5 3)) (EcoNarrator init: 1 0 0 2))
					((proc819_5 2) (EcoNarrator init: 1 0 0 37))
					(locked (EcoNarrator init: 1 0 0 5))
					((and (!= (gEgo x?) 79) (!= (gEgo y?) 145)) (global2 setScript: moveEgoToColumns 0 self))
					(else (self moveColumn:))
				)
			)
			(44
				(cond 
					((not (proc819_5 3)) (EcoNarrator init: 1 0 0 52))
					((proc819_5 2) (EcoNarrator init: 1 0 0 52))
					(else (EcoNarrator init: 1 0 0 53))
				)
			)
			(6 (EcoNarrator init: 1 0 0 51))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
	
	(method (moveColumn &tmp columnWhoDoIMove)
		(if (and (not (proc819_5 2)) (not locked))
			(self nextCel:)
			(if (not (proc819_5 120)) (= caller self))
			(if
			(and (self lock:) (not (self checkAlignment: 1)))
				(if (not (proc819_3 119))
					(EcoNarrator init: 1 0 0 40 caller)
				else
					(EcoNarrator init: 1 0 0 30 caller)
				)
			)
			(if
				(and
					(not aligned)
					(= columnWhoDoIMove (self whoDoIMove:))
				)
				(columnWhoDoIMove nextCel:)
			)
			(if (self checkAlignment: 1)
				(proc819_3 2)
				(proc0_4 10 264)
				(global2 setScript: maskFall)
			)
			(if (and (not gNewEventHandler) caller) (caller cue:))
		)
	)
	
	(method (lock &tmp temp0)
		(= temp0 0)
		(if
			(and
				(not locked)
				(= aligned (self checkAlignment:))
				(not cel)
			)
			(= locked 1)
			(gLongSong2 number: 169 loop: 1 play:)
			(= temp0 1)
		)
		(return temp0)
	)
	
	(method (nextCel)
		(if (> (++ cel) endCel) (= cel 0))
		(self forceUpd:)
		(gSoundEffects number: 164 loop: 1 play:)
		(Animate (gCast elements?) 0)
	)
	
	(method (checkAlignment &tmp temp0)
		(if (not argc)
			(= temp0 0)
			(while (< temp0 (columnList indexOf: self))
				(if (not ((columnList at: temp0) locked?))
					(return 0)
					(break)
				)
				(++ temp0)
			)
		else
			(= temp0 0)
			(while (< temp0 (columnList size?))
				(if (not ((columnList at: temp0) locked?))
					(return 0)
					(break)
				)
				(++ temp0)
			)
		)
		(return 1)
	)
	
	(method (whoDoIMove &tmp temp0)
		(if (= temp0 (columnList indexOf: self))
			(return (columnList at: (- temp0 1)))
		)
		(return 0)
	)
	
	(method (cue)
		(= caller 0)
		(proc819_3 120)
		((ScriptID 2 1) init: 3 0 0 42)
	)
)

(instance rm160 of EcoRoom
	(properties
		style $000a
		horizon 20
		south 120
	)
	
	(method (init)
		(= global251 1)
		(proc819_6)
		(gEgo
			init:
			posn: 160 215
			ignoreHorizon: 1
			setLoop: gStopGroop
			hide:
		)
		(= picture (if (== gSouth 200) 901 else 160))
		(self setRegions: 51)
		(super init:)
		(cols init:)
		(senatorMural init:)
		(seatedSenator init:)
		(opening init:)
		(floor init:)
		(if (and (proc819_5 2) (not (proc819_5 11)))
			(crab init:)
			(proc819_4 13)
		else
			(proc819_3 13)
		)
		(if (!= gSouth 200)
			(cond 
				((not (proc819_5 2))
					(column1_T init: 0)
					(column1_M init: 1)
					(column1_B init: 2)
					(column2_T init: 3)
					(column2_M init: 4)
					(column2_B init: 5)
					(column3_T init: 6)
					(column3_M init: 7)
					(column3_B init: 8)
					(goldMask init: stopUpd:)
					(if (not global175)
						(localproc_2b8c)
					else
						(localproc_2c1b)
					)
					(columnList eachElementDo: #stopUpd)
					(localproc_2d0c)
				)
				(
					(and
						(not (gEgo has: 2))
						(!= ((Inv at: 2) owner?) 140)
					)
					(goldMask loop: 1 cel: 15 x: 192 y: 93 init: stopUpd:)
				)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 189 0 0 319 0 319 189 305 189 305 8 11 8 11 189
					yourself:
				)
		)
		(if (== gSouth 200)
			(global2 setScript: thankYou)
		else
			(global2 setScript: enterScript)
		)
		(gLongSong
			number: (+ 160 (if (proc819_5 2) (not (proc819_5 11)) else 0))
			loop: -1
			play:
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 1) (self setScript: noExit))
		)
		(if
			(and
				(!= (gLongSong number?) 160)
				(== (gLongSong prevSignal?) -1)
			)
			(gLongSong number: 160 loop: -1 play:)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (self setScript: lookInRoom))
			(6 (EcoNarrator init: 1 0 0 48))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (not (proc819_5 2)) (localproc_2bde))
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance thankYou of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0 (proc0_1) (= ticks 30))
			(1
				(Message msgGET 160 1 0 1 25 @temp0)
				(Display
					@temp0
					dsCOORD
					105
					65
					dsCOLOR
					gInnerBordColor
					dsFONT
					6
				)
				(= seconds 5)
			)
			(2
				(global2 drawPic: 160 10)
				(proc819_6 3)
				(gEgo
					posn: 165 200
					show:
					ignoreHorizon: 1
					setCycle: Walk
					setMotion: MoveTo 165 181 self
				)
				(gDelph
					view: 831
					posn: 115 210
					setLoop: 3
					cel: 5
					setPri: 3
					yStep: 2
					ignoreActors:
					illegalBits: 0
					init:
					setCycle: 0
					setMotion: MoveTo 115 180
				)
				(goldMask loop: 1 cel: 15 x: 192 y: 93 init:)
				(crab init: illegalBits: 0 ignoreActors:)
				(cleaningFish1
					init:
					setCycle: Walk
					setMotion: MoveTo 335 198 self
				)
				(cleaningFish2
					init:
					setCycle: Walk
					setMotion: MoveTo 240 200 self
				)
				(cleaningFish3
					init:
					setCycle: Walk
					setMotion: MoveTo 30 200 self
				)
			)
			(3 0)
			(4 0)
			(5 0)
			(6
				(cleaningFish1 dispose:)
				(cleaningFish2 dispose:)
				(cleaningFish3 dispose:)
				(= cycles 1)
			)
			(7
				(Superfluous init: 2 0 0 13 0 self)
			)
			(8
				(Superfluous init: 2 0 0 14 1 self)
			)
			(9 (= cycles 1))
			(10
				((ScriptID 2 1) init: 3 0 0 10 1 self)
			)
			(11 (= cycles 1))
			(12
				(Superfluous init: 2 0 0 15 0 self)
			)
			(13
				(Superfluous init: 2 0 0 16 1 self)
			)
			(14 (= cycles 10))
			(15
				(gEgo setMotion: PolyPath 165 121 self)
			)
			(16
				(gEgo view: 161 loop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(17
				(goldMask dispose:)
				(gEgo setCycle: End self)
			)
			(18
				(proc0_4 2 268)
				(proc819_6)
				(gEgo get: 2 ignoreHorizon: 1)
				(= cycles 1)
			)
			(19
				((ScriptID 2 1) init: 3 0 0 11 1 self)
			)
			(20
				(gSoundEffects number: 603 loop: -1 flags: 1 play:)
				(crab setCycle: Walk setMotion: PolyPath 300 210 self)
				(gDelph setCycle: Walk setMotion: PolyPath 115 110 self)
			)
			(21 0)
			(22
				(gSoundEffects flags: 1 stop:)
				(gDelph setLoop: 0 cel: 7 setCycle: 0)
				(crab dispose:)
				(= cycles 13)
			)
			(23
				(proc819_9 gEgo gDelph self)
			)
			(24
				((ScriptID 2 0) init: 4 0 0 1 1 self)
			)
			(25 (= cycles 1))
			(26
				((ScriptID 2 1) init: 3 0 0 12 1 self)
			)
			(27 (= cycles 1))
			(28
				((ScriptID 2 0) init: 4 0 0 2 0 self)
			)
			(29
				((ScriptID 2 0) init: 4 0 0 4 1 self)
			)
			(30 (= cycles 1))
			(31
				((ScriptID 2 1) init: 3 0 0 13 1 self)
			)
			(32 (= cycles 1))
			(33
				((ScriptID 2 0) init: 4 0 0 3 1 self)
			)
			(34
				(gDelph
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 115 190
				)
				(gEgo setMotion: MoveTo 160 200 self)
			)
			(35
				(proc0_2)
				(global2 newRoom: 140)
			)
		)
	)
)

(instance moveEgoToColumns of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 79 145 self)
			)
			(1 (gEgo setHeading: 315 self))
			(2 (= cycles 6))
			(3
				(register doVerb: 4 0)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 1))
			(1
				(gEgo show: setMotion: MoveTo 165 181 self)
			)
			(2 (= cycles 12))
			(3
				(proc0_2)
				(cond 
					(
						(and
							(proc819_5 4)
							(not (proc819_5 3))
							(not (proc819_5 2))
						)
						(goldMask setScript: whoDares)
					)
					((and (proc819_5 2) (not (proc819_5 11))) (crab setScript: crabCry))
				)
				(= cycles 2)
			)
			(4 (self dispose:))
		)
	)
)

(instance maskFall of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(EcoNarrator init: 1 0 0 31 self)
			)
			(1
				(gLongSong2 number: 165 loop: 1 play:)
				(ShakeScreen 12 2)
				(proc819_3 2)
				(= cycles 1)
			)
			(2
				(EcoNarrator init: 1 0 0 34 self)
			)
			(3
				(proc819_9 gEgo goldMask)
				(goldMask loop: 1 cel: 0 x: 192 y: 93 setCycle: End self)
			)
			(4
				(gSoundEffects number: 168 loop: 1 play:)
				(goldMask stopUpd:)
				(= seconds 2)
			)
			(5
				(self setScript: walkOutOfShell self)
			)
			(6 (proc819_9 gEgo crab self))
			(7
				(EcoNarrator init: 1 0 0 35 self)
			)
			(8
				(proc0_2)
				(crab setScript: crabCry)
				(self dispose:)
			)
		)
	)
)

(instance crabCry of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc819_9 gEgo crab self))
			(1
				(Superfluous init: 2 0 0 24 0 self)
			)
			(2
				(Superfluous init: 2 0 0 8 1 self)
			)
			(3 (= seconds 6))
			(4
				(Superfluous init: 2 0 0 24 1 self)
			)
			(5 (= seconds 6))
			(6 (self changeState: 3))
		)
	)
)

(instance whoDares of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 2 0 0 1 self gNumber)
			)
			(1
				(EcoNarrator init: 1 0 0 29)
				(= seconds 10)
			)
			(2
				(EcoNarrator init: 2 0 0 2 self gNumber)
			)
			(3 (= seconds 20))
			(4
				(= local2 55)
				(global2 setScript: senatorSpeech)
				(self dispose:)
			)
		)
	)
)

(instance senatorSpeech of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 1))
			(1 (proc819_9 gEgo crab self))
			(2
				(EcoNarrator init: 1 0 0 local2 self)
			)
			(3
				((ScriptID 2 1) init: 3 0 0 1 1 self)
			)
			(4
				(EcoNarrator init: 2 0 0 3 self)
			)
			(5
				((ScriptID 2 1) init: 3 0 0 2 1 self)
			)
			(6
				(EcoNarrator init: 2 0 0 4 self)
			)
			(7
				((ScriptID 2 1) init: 3 0 0 3 1 self)
			)
			(8
				(EcoNarrator init: 2 0 0 5 self)
			)
			(9
				(EcoNarrator init: 2 0 0 31 self)
			)
			(10
				((ScriptID 2 1) init: 3 0 0 4 1 self)
			)
			(11
				(EcoNarrator init: 2 0 0 6 self)
			)
			(12
				(EcoNarrator init: 2 0 0 32 self)
			)
			(13
				((ScriptID 2 1) init: 3 0 0 5 1 self)
			)
			(14
				(EcoNarrator init: 2 0 0 7 self)
			)
			(15
				((ScriptID 2 1) init: 3 0 0 44 1 self)
			)
			(16
				(EcoNarrator init: 2 0 0 36 self)
			)
			(17
				(EcoNarrator init: 2 0 0 33 self)
			)
			(18
				(proc819_3 3)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance crabWhine of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_9 gEgo crab self)
			)
			(1
				((ScriptID 2 1) init: 3 0 0 6 1 self)
			)
			(2 (= cycles 1))
			(3
				(Superfluous init: 2 0 0 9 1 self)
			)
			(4 (= cycles 1))
			(5
				((ScriptID 2 1) init: 3 0 0 7 1 self)
			)
			(6 (= cycles 1))
			(7
				(Superfluous init: 2 0 0 10 1 self)
			)
			(8 (= cycles 1))
			(9
				((ScriptID 2 1) init: 3 0 0 8 1 self)
			)
			(10 (= cycles 1))
			(11
				(Superfluous init: 2 0 0 11 0 self)
			)
			(12
				(Superfluous init: 2 0 0 25 1 self)
			)
			(13 (= cycles 1))
			(14
				((ScriptID 2 1) init: 3 0 0 9 1 self)
			)
			(15 (= cycles 1))
			(16
				(Superfluous init: 2 0 0 12 0 self)
			)
			(17
				(Superfluous init: 2 0 0 26 1 self)
			)
			(18
				(proc819_3 11)
				(self setScript: walkUnderShell self)
			)
			(19 (proc0_2) (self dispose:))
		)
	)
)

(instance getInCleanShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(crab setScript: 0)
				(if (not (proc819_5 13))
					(self changeState: 2)
				else
					((ScriptID 2 1) init: 3 0 0 18 1 self)
				)
			)
			(1
				(self setScript: walkOutOfShell self)
			)
			(2
				((ScriptID 2 1) init: 3 0 0 14 1 self)
			)
			(3
				(gEgo setMotion: MoveTo 191 96 self)
			)
			(4 (= cycles 12))
			(5
				(gEgo
					setCycle: 0
					view: 168
					loop: 0
					cel: 0
					posn: 169 115
					cycleSpeed: 11
					looper: 0
					setCycle: End self
				)
			)
			(6 (proc819_9 gEgo crab self))
			(7
				(Superfluous init: 2 0 0 21 1 self)
			)
			(8
				((ScriptID 2 1) init: 3 0 0 16 1 self)
			)
			(9
				(gEgo hide:)
				(goldMask hide:)
				(NSET init:)
				(crab
					view: 163
					loop: 1
					cel: 0
					x: 155
					y: 133
					cycleSpeed: 10
					setPri: 8
					illegalBits: 0
					setCycle: End
				)
				(= cycles 10)
			)
			(10
				(crab
					view: 163
					loop: 2
					x: 155
					y: 133
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(11
				(gSoundEffects number: 603 loop: 1 play:)
				(crab
					view: 163
					loop: 3
					x: 155
					y: 133
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(12
				(gSoundEffects number: 163 loop: 1 play:)
				(crab
					view: 163
					loop: 4
					x: 186
					y: 106
					cel: 0
					cycleSpeed: 9
				)
				(= cycles 9)
			)
			(13
				(gSoundEffects number: 163 loop: 1 play:)
				(crab cel: 1 cycleSpeed: 4 setCycle: End self)
			)
			(14
				(gSoundEffects stop:)
				(= seconds 2)
			)
			(15
				(gSoundEffects number: 163 loop: 1 play:)
				(crab setCycle: Beg self)
			)
			(16
				(gSoundEffects stop:)
				(= cycles 10)
			)
			(17 (proc819_9 gEgo crab self))
			(18
				(Superfluous init: 2 0 0 22 0 self)
			)
			(19
				(Superfluous init: 2 0 0 29 1 self)
			)
			(20
				((ScriptID 2 1) init: 3 0 0 19 1 self)
			)
			(21 (= cycles 10))
			(22
				(gSoundEffects number: 163 loop: 1 play:)
				(crab setCycle: End self)
			)
			(23 (= seconds 2))
			(24
				(gSoundEffects number: 163 loop: 1 play:)
				(crab
					view: 163
					loop: 5
					cel: 0
					x: 186
					y: 106
					cycleSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(25
				(gSoundEffects number: 167 loop: 1 play:)
				(crab setCycle: End self)
			)
			(26
				(proc0_4 5 267)
				(gEgo put: 22 160 get: 1)
				(Superfluous init: 2 0 0 30 1 self)
			)
			(27
				(EcoNarrator posn: -1 15 init: 1 0 0 1 self)
			)
			(28
				(gSoundEffects number: 163 loop: 1 play:)
				(crab
					view: 163
					loop: 4
					x: 186
					y: 106
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(29 (= seconds 1))
			(30
				(NSET dispose:)
				(goldMask show:)
				(crab
					view: 162
					loop: 0
					cel: 0
					posn: 194 130
					setCycle: Walk
				)
				(proc819_4 116)
				(gEgo show: posn: 160 127)
				(proc819_6)
				(gEgo ignoreHorizon: 1)
				(= seconds 2)
			)
			(31
				(self setScript: walkUnderShell self)
			)
			(32 (proc0_2) (self dispose:))
		)
	)
)

(instance getInOilyShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_9 gEgo crab self)
			)
			(1
				(crab setScript: 0)
				(if (not (proc819_5 13))
					(self changeState: 2)
				else
					((ScriptID 2 1) init: 3 0 0 18 1 self)
				)
			)
			(2
				(self setScript: walkOutOfShell self)
			)
			(3
				((ScriptID 2 1) init: 3 0 0 14 1 self)
			)
			(4
				(gEgo setMotion: MoveTo 191 96 self)
			)
			(5 (= cycles 12))
			(6
				(gEgo
					setCycle: 0
					view: 168
					loop: 0
					cel: 0
					posn: 169 115
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(7
				(if (== local1 1)
					(Superfluous init: 2 0 0 28 1 self)
				else
					(self changeState: 8)
				)
			)
			(8 (self changeState: 11))
			(9
				(Superfluous init: 2 0 0 19 1 self)
			)
			(10
				((ScriptID 2 1) init: 3 0 0 15 1 self)
			)
			(11
				(Superfluous init: 2 0 0 20 1 self)
			)
			(12
				(= local1 1)
				(proc819_3 116)
				(proc819_6)
				(gEgo posn: 160 127 ignoreHorizon: 1)
				(= cycles 12)
			)
			(13
				(self setScript: walkUnderShell self)
			)
			(14 (proc0_2) (self dispose:))
		)
	)
)

(instance walkOutOfShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 161 loop: -1 play:)
				(goldMask hide:)
				(crab
					view: 167
					loop: 0
					cel: 0
					posn: 181 125
					cycleSpeed: 14
					setPri: 0
					init:
					setCycle: End self
				)
			)
			(1
				(crab view: 162 loop: 0 cel: 1 posn: 184 125)
				(goldMask view: 160 loop: 1 cel: 15 posn: 192 97 show:)
				(= cycles 3)
			)
			(2
				(proc819_4 13)
				(crab
					setCycle: Walk
					setMotion: DPath 194 125 194 130 self
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance walkUnderShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(goldMask hide:)
				(crab
					view: 167
					loop: 1
					cel: 0
					posn: 179 130
					cycleSpeed: 14
					setCycle: End self
				)
				(gLongSong fade: 30 25 10 1)
			)
			(1
				(crab dispose:)
				(goldMask show:)
				(proc819_3 13)
				(= cycles 1)
			)
			(2 (self dispose:))
		)
	)
)

(instance superflBeforeNewShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_9 gEgo crab self)
			)
			(1
				(if (proc819_5 13)
					((ScriptID 2 1) init: 3 0 0 17 1 self)
				else
					(self changeState: 2)
				)
			)
			(2
				(self setScript: walkOutOfShell self)
			)
			(3
				(if (== local0 1)
					(Superfluous init: 2 0 0 27 1 self)
				else
					(Superfluous init: 2 0 0 17 1 self)
				)
			)
			(4
				(if (not (gEgo has: 22))
					(self setScript: walkUnderShell self)
				else
					(= cycles 1)
				)
			)
			(5
				(= local0 1)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance keepWorkingOnApts of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_9 gEgo crab self)
			)
			(1
				(if (proc819_5 13)
					((ScriptID 2 1) init: 3 0 0 17 1 self)
				else
					(self changeState: 2)
				)
			)
			(2
				(self setScript: walkOutOfShell self)
			)
			(3
				(Superfluous init: 2 0 0 18 1 self)
			)
			(4
				(self setScript: walkUnderShell self)
			)
			(5 (proc0_2) (self dispose:))
		)
	)
)

(instance muralLook of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 1 0 0 28 self)
			)
			(1
				(if (not (proc819_5 2))
					(EcoNarrator init: 1 0 0 8 self)
				else
					(= cycles 1)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance handOnMask of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(if (proc819_5 2)
					(gEgo setMotion: MoveTo 181 142 self)
				else
					(gEgo setMotion: MoveTo 197 89 self)
				)
			)
			(1 (gEgo setHeading: 0 self))
			(2 (= cycles 12))
			(3
				(if (and (proc819_5 2) (not (gEgo has: 2)))
					(cond 
						((proc819_5 13) (EcoNarrator init: 1 0 0 27 self))
						(
							(and
								(not (proc819_5 13))
								(== ((Inv at: 21) owner?) 226)
							)
							(EcoNarrator init: 1 0 0 38 self)
						)
					)
				else
					(EcoNarrator init: 1 0 0 14 self)
				)
			)
			(4 (proc0_2) (self dispose:))
		)
	)
)

(instance potionOnSuperfl of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_9 gEgo crab self)
			)
			(1
				((ScriptID 2 1) init: 3 0 0 43 1 self)
			)
			(2
				(Superfluous init: 2 0 0 35 1 self)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance noExit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(EcoNarrator init: 1 0 0 43 self)
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

(instance lookInRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 1 0 0 12 self)
			)
			(1
				(if (not (proc819_5 2))
					(EcoNarrator init: 1 0 0 13 self)
				else
					(= cycles 1)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance doRiddle of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(EcoNarrator init: 1 0 0 57 self)
			)
			(1
				(EcoNarrator init: 2 0 0 36 self)
				(= cycles 1)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance columnList of List
	(properties)
	
	(method (delete)
		(super delete: &rest)
		(if (not size) (self dispose:))
	)
)

(instance tmpList of List
	(properties)
)

(instance column1_T of Column
	(properties
		x 16
		y 21
		view 164
		cel 2
	)
)

(instance column1_M of Column
	(properties
		x 19
		y 73
		view 164
		loop 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not (proc819_5 3))
					(switch cel
						(0 (EcoNarrator store: 19))
						(1 (EcoNarrator store: 18))
						(2 (EcoNarrator store: 17))
					)
					(EcoNarrator init: 1 0 0 4)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance column1_B of Column
	(properties
		x 17
		y 135
		view 164
		loop 2
		cel 1
	)
)

(instance column2_T of Column
	(properties
		x 52
		y 25
		view 164
		loop 3
	)
)

(instance column2_M of Column
	(properties
		x 57
		y 72
		view 164
		loop 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not (proc819_5 3))
					(switch cel
						(0 (EcoNarrator store: 18))
						(1 (EcoNarrator store: 17))
						(2 (EcoNarrator store: 19))
					)
					(EcoNarrator init: 1 0 0 4)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance column2_B of Column
	(properties
		x 53
		y 129
		view 164
		loop 5
	)
)

(instance column3_T of Column
	(properties
		x 89
		y 39
		view 164
		loop 6
	)
)

(instance column3_M of Column
	(properties
		x 90
		y 89
		view 164
		loop 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not (proc819_5 3))
					(switch cel
						(0 (EcoNarrator store: 17))
						(1 (EcoNarrator store: 19))
						(2 (EcoNarrator store: 18))
					)
					(EcoNarrator init: 1 0 0 4)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance column3_B of Column
	(properties
		x 90
		y 126
		view 164
		loop 8
		cel 2
	)
)

(instance cols of EcoFeature
	(properties
		onMeCheck $0002
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((and (proc819_5 3) (not (proc819_5 2))) (global2 setScript: doRiddle))
					((proc819_5 2) (EcoNarrator init: 1 0 0 32))
					(else (EcoNarrator init: 1 0 0 4))
				)
			)
			(4
				(if (proc819_5 3)
					(if (< ((User curEvent?) x?) 160)
						(if (proc819_5 2)
							(EcoNarrator init: 1 0 0 32)
						else
							(EcoNarrator init: 1 0 0 62)
						)
					else
						(EcoNarrator init: 1 0 0 46)
					)
				else
					(EcoNarrator init: 1 0 0 2)
				)
			)
			(44
				(if (and (proc819_5 3) (not (proc819_5 2)))
					(EcoNarrator init: 1 0 0 53)
				else
					(EcoNarrator init: 1 0 0 52)
				)
			)
			(6 (EcoNarrator init: 1 0 0 51))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance senatorMural of EcoFeature
	(properties
		onMeCheck $0004
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(global2 setScript: muralLook)
			)
			(4 (EcoNarrator init: 1 0 0 44))
			(44
				(EcoNarrator init: 1 0 0 44)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance seatedSenator of EcoFeature
	(properties
		onMeCheck $0020
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(global2 setScript: senatorLook)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance senatorLook of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 1 0 0 9 self)
			)
			(1
				(if (not (proc819_5 2))
					(EcoNarrator init: 1 0 0 10 self)
				else
					(= cycles 1)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance opening of EcoFeature
	(properties
		onMeCheck $0008
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 42))
			(4 (EcoNarrator init: 1 0 0 43))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance floor of EcoFeature
	(properties
		onMeCheck $0010
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 41))
			(4 (EcoNarrator init: 1 0 0 45))
			(44
				(EcoNarrator init: 1 0 0 54)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance goldMask of EcoProp
	(properties
		x 196
		y 71
		sightAngle 90
		view 160
		priority 1
		signal $4011
	)
	
	(method (init)
		(super init: &rest)
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
				(User canInput:)
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
				(not (pEvent modifiers?))
			)
			(cond 
				(
					(and
						(== (gIconBar curIcon?) (gIconBar at: 3))
						(== (crab script?) crabCry)
						(not (crab onMe: pEvent))
					)
					(EcoNarrator init: 1 0 0 58)
					(pEvent claimed: 1)
				)
				(
					(and
						(== (gIconBar curIcon?) (gIconBar at: 4))
						(== (gIconBar curInvIcon?) (Inv at: 22))
						(== (crab script?) crabCry)
						(crab onMe: pEvent)
					)
					(EcoNarrator init: 1 0 0 60)
					(pEvent claimed: 1)
				)
				(
					(and
						(== (gIconBar curIcon?) (gIconBar at: 3))
						(localproc_2c71)
					)
					(if (== (CueObj client?) self)
						(super handleEvent: pEvent)
					else
						(pEvent claimed: 1)
					)
				)
				(
					(and
						(== (gIconBar curIcon?) (gIconBar at: 4))
						(== (gIconBar curInvIcon?) (Inv at: 22))
						(not (self onMe: pEvent))
						(or
							(and (gCast contains: crab) (not (crab onMe: pEvent)))
							(not (gCast contains: crab))
						)
					)
					(EcoNarrator init: 1 0 0 39)
					(pEvent claimed: 1)
				)
				(
					(and
						(== (gIconBar curIcon?) (gIconBar at: 4))
						(not (proc819_5 13))
						(self onMe: pEvent)
					)
					(EcoNarrator init: 1 0 0 59)
					(pEvent claimed: 1)
				)
				(else (super handleEvent: pEvent))
			)
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
				(if (proc819_5 2)
					(if (proc819_5 12)
						(EcoNarrator init: 1 0 0 26)
					else
						(EcoNarrator init: 1 0 0 20)
						(proc819_3 12)
					)
				else
					(EcoNarrator init: 1 0 0 11)
				)
			)
			(4
				(global2 setScript: handOnMask)
			)
			(2
				(cond 
					((proc819_5 13)
						(cond 
							((not (== ((Inv at: 22) owner?) 160)) (global2 setScript: superflBeforeNewShell))
							(
								(and
									(== ((Inv at: 22) owner?) 160)
									(== ((Inv at: 21) owner?) 226)
								)
								(global2 setScript: keepWorkingOnApts)
							)
						)
					)
					((proc819_5 2) (EcoNarrator init: 1 0 0 49))
				)
			)
			(6 (EcoNarrator init: 1 0 0 47))
			(44
				(switch theTheVerb
					(31
						(if (proc819_5 2)
							(if (proc819_5 13)
								(if (== global232 4)
									(global2 setScript: getInCleanShell)
								else
									(global2 setScript: getInOilyShell)
								)
							else
								(EcoNarrator init: 1 0 0 39)
							)
						else
							(EcoNarrator init: 1 0 0 50)
						)
					)
					(else 
						(if (proc819_5 2)
							(if (proc819_5 13)
								(EcoNarrator init: 1 0 0 27)
							else
								(EcoNarrator init: 1 0 0 38)
							)
						else
							(EcoNarrator init: 1 0 0 16)
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

(instance crab of EcoActor
	(properties
		x 194
		y 130
		view 162
		loop 2
		cel 2
		signal $4000
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 11)
					(EcoNarrator init: 1 0 0 24)
				else
					(EcoNarrator init: 1 0 0 21)
				)
			)
			(4
				(if (proc819_5 11)
					(EcoNarrator init: 1 0 0 56)
				else
					(EcoNarrator init: 1 0 0 22)
				)
			)
			(2
				(cond 
					((or (not (proc819_5 11)) (== script crabCry))
						(if (== (crab script?) crabCry) (crabCry dispose:))
						(proc0_4 2 266)
						(global2 setScript: crabWhine)
					)
					((not (== ((Inv at: 22) owner?) 160)) (global2 setScript: superflBeforeNewShell))
					(
						(and
							(== ((Inv at: 22) owner?) 160)
							(== ((Inv at: 21) owner?) 226)
						)
						(global2 setScript: keepWorkingOnApts)
					)
				)
			)
			(44
				(switch theTheVerb
					(31
						(cond 
							((not (proc819_5 11)) (EcoNarrator init: 1 0 0 60))
							((== global232 4) (global2 setScript: getInCleanShell))
							(else (global2 setScript: getInOilyShell))
						)
					)
					(12
						(if (not (proc819_5 11))
							(EcoNarrator init: 1 0 0 60)
						else
							(global2 setScript: potionOnSuperfl)
						)
					)
					(else 
						(if (not (proc819_5 11))
							(EcoNarrator init: 1 0 0 60)
						else
							(EcoNarrator init: 1 0 0 23)
						)
					)
				)
			)
			(6
				(Superfluous init: 2 0 0 34 1)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance cleaningFish1 of EcoActor
	(properties
		x 234
		y 145
		view 123
		priority 1
		signal $4810
	)
)

(instance cleaningFish2 of EcoActor
	(properties
		x 181
		y 167
		view 123
		loop 2
		priority 1
		signal $4810
	)
)

(instance cleaningFish3 of EcoActor
	(properties
		x 104
		y 152
		view 123
		loop 4
		priority 1
		signal $4810
	)
)

(instance NSET of EcoView
	(properties
		x 72
		y 47
		view 163
		priority 1
		signal $0011
	)
)

(instance Superfluous of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 166
		charNum 5
		keepWindow 1
	)
	
	(method (init)
		(super init: sBust sEyes sMouth &rest)
	)
)

(instance sBust of EcoProp
	(properties
		view 166
	)
)

(instance sEyes of EcoProp
	(properties
		nsTop 6
		nsLeft 4
		view 166
		loop 2
		cycleSpeed 30
	)
)

(instance sMouth of EcoProp
	(properties
		view 166
		loop 1
		cycleSpeed 10
	)
)
