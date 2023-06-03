;;; Sierra Script 1.0 - (do not remove this comment)
(script# 928)
(include sci.sh)
(use Main)
(use EcoFeature)
(use EcoDialog)
(use Sync)
(use RandCycle)
(use Obj)


(class RTRandCycle of RandCycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		count -1
		reset 0
	)
	
	(method (init param1 param2 theCaller)
		(super init: param1)
		(client cel: 0)
		(= cycleCnt (GetTime))
		(if (>= argc 2)
			(if (!= param2 -1)
				(= count (+ (GetTime) param2))
			else
				(= count -1)
			)
			(if (>= argc 3) (= caller theCaller))
		else
			(= count -1)
		)
	)
	
	(method (doit &tmp temp0)
		(if
		(or (> count (= temp0 (GetTime))) (== count -1))
			(if (> (- temp0 cycleCnt) (client cycleSpeed?))
				(client cel: (self nextCel:))
				(= cycleCnt (GetTime))
			)
		else
			(client cel: 0)
			(self cycleDone:)
		)
	)
)

(class EcoTalker of EcoProp
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
		lookStr 0
		bust 0
		eyes 0
		mouth 0
		ticks 0
		disposeWhenDone 1
		caller 0
		useFrame 0
		talkWidth 318
		viewInPrint 0
		cueVal 0
		modeless 0
		killIt 0
		charNum 0
		keepWindow 0
		cycleEyes 1
		tNoun 0
		curVolume -1
	)
	
	(method (init theBust theEyes theMouth theTNoun param5 param6 param7 theDisposeWhenDone theCaller theModNum &tmp temp0)
		(if argc
			(= bust theBust)
			(if (>= argc 2)
				(= eyes theEyes)
				(if (>= argc 3)
					(= mouth theMouth)
					(if (>= argc 4)
						(= tNoun theTNoun)
						(if (>= argc 8)
							(= disposeWhenDone theDisposeWhenDone)
							(if (>= argc 9)
								(= caller theCaller)
								(if (>= argc 10) (= modNum theModNum))
							)
						)
					)
				)
			)
		)
		(self setSize:)
		(if (>= argc 4) (self say: param5 param6 param7))
	)
	
	(method (doit)
		(cond 
			(killIt (= killIt 0) (self dispose: disposeWhenDone))
			((> (- gCycleCnt ticks) 0)
				(if
					(and
						(if (& global90 $0002) (== (DoAudio 6) -1) else 1)
						(or (not keepWindow) (not (& global90 $0001)))
					)
					(self cue:)
					(return 0)
				)
			)
		)
		(if mouth (self cycle: mouth))
		(if eyes (self cycle: eyes))
		(return 1)
	)
	
	(method (dispose param1 &tmp theCaller)
		(if (and mouth (mouth cycler?))
			(if ((mouth cycler?) respondsTo: #cue)
				((mouth cycler?) cue:)
			)
			(mouth setCycle: 0)
		)
		(if (or (not argc) param1)
			(if modeless
				(gEcoMouseDownHandler delete: self)
				(gEcoKeyDownHandler delete: self)
			)
			(if eyes (eyes setCycle: 0))
			(self hide:)
			(= modNum -1)
		)
		(if (& global90 $0002) (DoAudio 3))
		(if (and param1 gTheNewEcoDialog)
			(gTheNewEcoDialog dispose:)
		)
		(gTheDoits delete: self)
		(Animate (gCast elements?) 0)
		(if caller
			(= theCaller caller)
			(= caller 0)
			(theCaller cue: cueVal)
		)
		(= cueVal 0)
		(DisposeClone self)
	)
	
	(method (handleEvent pEvent)
		(return
			(cond 
				((pEvent claimed?))
				((== ticks -1) (return 0))
				(else
					(switch (pEvent type?)
						(evJOYDOWN (= cueVal 0))
						(evMOUSEBUTTON
							(= cueVal (& (pEvent modifiers?) emSHIFT))
						)
						(evKEYBOARD
							(= cueVal (== (pEvent message?) KEY_ESCAPE))
						)
					)
					(if
						(and
							(or
								(& (pEvent type?) $4101)
								(and
									(& (pEvent type?) evKEYBOARD)
									(proc999_5 (pEvent message?) 13 27)
								)
							)
							(not killIt)
						)
						(self cue:)
					)
				)
			)
		)
	)
	
	(method (hide)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
		(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
		(gIconBar enable:)
	)
	
	(method (show &tmp temp0)
		(if (== view -1) (return))
		(if (not underBits)
			(= underBits
				(Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1)
			)
		)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(if bust
			(DrawCel
				(bust view?)
				(bust loop?)
				(bust cel?)
				(+ (bust nsLeft?) nsLeft)
				(+ (bust nsTop?) nsTop)
				-1
			)
		)
		(if eyes
			(DrawCel
				(eyes view?)
				(eyes loop?)
				(eyes cel?)
				(+ (eyes nsLeft?) nsLeft)
				(+ (eyes nsTop?) nsTop)
				-1
			)
		)
		(if mouth
			(DrawCel
				(mouth view?)
				(mouth loop?)
				(mouth cel?)
				(+ (mouth nsLeft?) nsLeft)
				(+ (mouth nsTop?) nsTop)
				-1
			)
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid temp0)
	)
	
	(method (cue)
		(if (not modeless) (gTheDoits add: self))
		(= killIt 1)
		(if (& global90 $0002) (gGame masterVolume: curVolume))
		(if
		(and gNewEventHandler (gNewEventHandler contains: self))
			(gNewEventHandler delete: self)
			(if (gNewEventHandler isEmpty:)
				(gNewEventHandler dispose:)
				(= gNewEventHandler 0)
			)
		)
	)
	
	(method (say param1 param2 param3 &tmp newEvent)
		(if (not gTheNewEcoDialog) (gIconBar disable:))
		(if (== modNum -1) (= modNum gNumber))
		(if (& global90 $0002)
			(= curVolume (gGame masterVolume:))
			(if (>= (gGame masterVolume:) 4)
				(gGame masterVolume: (- curVolume 4))
			)
		)
		(cond 
			((> param3 72)
				(= param3 (- param3 72))
				(cond 
					((== global251 1) (= param2 2))
					((== global251 2) (= param2 1))
				)
			)
			((> param3 36) (= param3 (- param3 36)) (= param2 global251))
		)
		(if (& global90 $0001)
			(self startText: param1 param2 param3)
		)
		(if (& global90 $0002)
			(self startAudio: param1 param2 param3)
		)
		(cond 
			(modeless
				(gEcoMouseDownHandler addToFront: self)
				(gEcoKeyDownHandler addToFront: self)
				(gTheDoits add: self)
			)
			((IsObject gNewEventHandler) (gNewEventHandler add: self))
			(else ((= gNewEventHandler (EventHandler new:)) add: self))
		)
		(= ticks (+ ticks 60 gCycleCnt))
		(if (and (not modeless) gNewEventHandler)
			(while gNewEventHandler
				(gNewEventHandler eachElementDo: #doit)
				(if
					(and
						((= newEvent (Event new:)) type?)
						gNewEventHandler
					)
					(gNewEventHandler firstTrue: #handleEvent newEvent)
				)
				(if newEvent (newEvent dispose:))
				(= gCycleCnt (+ global86 (GetTime)))
				(gSounds eachElementDo: #check)
			)
		)
		(return 1)
	)
	
	(method (startAudio param1 param2 param3)
		(self show:)
		(if mouth
			(mouth
				setCycle: MouthSync modNum tNoun param1 param2 param3
			)
			(if (not (mouth cycler?))
				(mouth setCycle: RTRandCycle)
			)
		)
		(if (and eyes (not (eyes cycler?)))
			(eyes setCycle: RTRandCycle (if cycleEyes -1 else ticks))
		)
		(= ticks (DoAudio 2 modNum tNoun param1 param2 param3))
	)
	
	(method (startText param1 param2 param3 &tmp [temp0 500] temp500)
		(Message msgGET modNum tNoun param1 param2 param3 @temp0)
		(= ticks (* 5 (= temp500 (StrLen @temp0))))
		(self show:)
		(if gTheNewEcoDialog (gTheNewEcoDialog dispose:))
		(self display: @temp0)
		(if mouth (mouth setCycle: RTRandCycle ticks))
		(if eyes
			(eyes setCycle: RTRandCycle (if cycleEyes -1 else ticks))
		)
		(if (not keepWindow)
			(= ticks (proc999_3 100 (* 2 temp500)))
		)
	)
	
	(method (display)
		(= x (+ nsRight 15))
		(= y nsTop)
		(proc821_1 &rest 64 x y 111 77 name)
	)
	
	(method (cycle param1 &tmp temp0 [temp1 100])
		(if (and param1 (param1 cycler?))
			(= temp0 (param1 cel?))
			((param1 cycler?) doit:)
			(if (!= temp0 (param1 cel?))
				(DrawCel
					(param1 view?)
					(param1 loop?)
					(param1 cel?)
					(+ (param1 nsLeft?) nsLeft)
					(+ (param1 nsTop?) nsTop)
					-1
				)
				(param1
					nsRight:
						(+
							(param1 nsLeft?)
							(CelWide (param1 view?) (param1 loop?) (param1 cel?))
						)
				)
				(param1
					nsBottom:
						(+
							(param1 nsTop?)
							(CelHigh (param1 view?) (param1 loop?) (param1 cel?))
						)
				)
				(Graph
					grUPDATE_BOX
					(+ (param1 nsTop?) nsTop)
					(+ (param1 nsLeft?) nsLeft)
					(+ (param1 nsBottom?) nsTop)
					(+ (param1 nsRight?) nsLeft)
					1
				)
			)
		)
	)
	
	(method (setSize)
		(= nsRight
			(+
				nsLeft
				(proc999_3
					(if (!= view -1) (CelWide view loop cel) else 0)
					(if (IsObject bust)
						(+
							(bust nsLeft?)
							(CelWide (bust view?) (bust loop?) (bust cel?))
						)
					else
						0
					)
					(if (IsObject eyes)
						(+
							(eyes nsLeft?)
							(CelWide (eyes view?) (eyes loop?) (eyes cel?))
						)
					else
						0
					)
					(if (IsObject mouth)
						(+
							(mouth nsLeft?)
							(CelWide (mouth view?) (mouth loop?) (mouth cel?))
						)
					else
						0
					)
				)
			)
		)
		(= nsBottom
			(+
				nsTop
				(proc999_3
					(if (!= view -1) (CelHigh view loop cel) else 0)
					(if (IsObject bust)
						(+
							(bust nsTop?)
							(CelHigh (bust view?) (bust loop?) (bust cel?))
						)
					else
						0
					)
					(if (IsObject eyes)
						(+
							(eyes nsTop?)
							(CelHigh (eyes view?) (eyes loop?) (eyes cel?))
						)
					else
						0
					)
					(if (IsObject mouth)
						(+
							(mouth nsTop?)
							(CelHigh (mouth view?) (mouth loop?) (mouth cel?))
						)
					else
						0
					)
				)
			)
		)
	)
)

(class EcoNarrator of EcoTalker
	(properties
		x -1
		y -1
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
		lookStr 0
		bust 0
		eyes 0
		mouth 0
		ticks 0
		disposeWhenDone 1
		caller 0
		useFrame 0
		talkWidth 0
		viewInPrint 0
		cueVal 0
		modeless 0
		killIt 0
		charNum 99
		keepWindow 1
		cycleEyes 1
		tNoun 0
		curVolume -1
		eraseOnly 0
		origNarNum 0
		inInv 0
		store 0
		isStored 0
	)
	
	(method (init theOrigNarNum param2 param3 param4 theCaller theModNum)
		(= eraseOnly (if eraseOnly else (gEcoWin eraseOnly?)))
		(if (>= argc 5)
			(= caller theCaller)
			(if (>= argc 6) (= modNum theModNum))
		)
		(if
			(and
				(not (== (= origNarNum theOrigNarNum) (+ global250 1)))
				(>= param4 100)
			)
			(= theOrigNarNum (+ theOrigNarNum 1))
			(= param4 (- param4 100))
		)
		(= tNoun theOrigNarNum)
		(super say: param2 param3 param4)
	)
	
	(method (doit)
		(cond 
			(killIt (= killIt 0) (self dispose: disposeWhenDone))
			((> (- gCycleCnt ticks) 0)
				(if
					(and
						(if (& global90 $0002) (== (DoAudio 6) -1) else 1)
						(or (not keepWindow) (not (& global90 $0001)))
					)
					(if isStored (= isStored (= store 0)))
					(self cue:)
					(return 0)
				)
			)
		)
		(if mouth (self cycle: mouth))
		(if eyes (self cycle: eyes))
		(return 1)
	)
	
	(method (dispose param1 &tmp temp0 theCaller)
		(if store
			(= killIt 0)
			(= isStored 1)
			(self init: tNoun 0 0 store caller modNum)
		)
		(if killIt (= killIt 0))
		(= tNoun origNarNum)
		(= origNarNum 0)
		(= y (= x -1))
		(= eraseOnly (= modNum (= talkWidth 0)))
		(if (and mouth (mouth cycler?))
			(if ((mouth cycler?) respondsTo: #cue)
				((mouth cycler?) cue:)
			)
			(mouth setCycle: 0)
		)
		(if (or (not argc) param1)
			(if eyes (eyes setCycle: 0))
			(self hide:)
			(= modNum -1)
		)
		(if
		(and gTheNewEcoDialog (or param1 (& global90 $0001)))
			(gTheNewEcoDialog dispose:)
		)
		(if (& global90 $0002) (DoAudio 3))
		(if (not inInv)
			(gTheDoits delete: self)
			(Animate (gCast elements?) 0)
		)
		(if caller
			(= theCaller caller)
			(= caller 0)
			(theCaller cue: cueVal)
		)
		(= cueVal 0)
		(DisposeClone self)
	)
	
	(method (handleEvent pEvent)
		(return
			(cond 
				((pEvent claimed?))
				((== ticks -1) (return 0))
				(else
					(switch (pEvent type?)
						(evJOYDOWN (= cueVal 0))
						(evMOUSEBUTTON
							(= cueVal (& (pEvent modifiers?) emSHIFT))
						)
						(evKEYBOARD
							(= cueVal (== (pEvent message?) KEY_ESCAPE))
						)
					)
					(if
						(or
							(& (pEvent type?) $4101)
							(and
								(& (pEvent type?) evKEYBOARD)
								(proc999_5 (pEvent message?) 13 27)
							)
						)
						(if isStored (= isStored (= store 0)))
						(if (not killIt) (self cue:))
					)
				)
			)
		)
	)
	
	(method (posn theX theY)
		(if (>= argc 1)
			(= x theX)
			(if (>= argc 2) (= y theY))
		)
	)
	
	(method (cue)
		(if (not inInv) (gTheDoits add: self))
		(= killIt 1)
		(if (& global90 $0002) (gGame masterVolume: curVolume))
		(if
			(and
				gNewEventHandler
				(gNewEventHandler contains: self)
				(not store)
			)
			(gNewEventHandler delete: self)
			(if (gNewEventHandler isEmpty:)
				(gNewEventHandler dispose:)
				(= gNewEventHandler 0)
			)
		)
		(if inInv (= killIt 0) (self dispose: disposeWhenDone))
	)
	
	(method (startAudio param1 param2 param3)
		(= ticks (DoAudio 2 modNum tNoun param1 param2 param3))
	)
	
	(method (startText param1 param2 param3 &tmp [temp0 500] temp500)
		(Message msgGET modNum tNoun param1 param2 param3 @temp0)
		(= ticks (* 5 (= temp500 (StrLen @temp0))))
		(self show:)
		(if gTheNewEcoDialog (gTheNewEcoDialog dispose:))
		(self display: @temp0)
		(if (not keepWindow)
			(= ticks (proc999_3 240 (* 8 temp500)))
		)
	)
	
	(method (display &tmp gEcoWinEraseOnly)
		(= gEcoWinEraseOnly (gEcoWin eraseOnly?))
		(gEcoWin eraseOnly: eraseOnly)
		(proc821_1 &rest 64 x y 111 77 name)
		(gEcoWin eraseOnly: gEcoWinEraseOnly)
	)
)
