;;; Sierra Script 1.0 - (do not remove this comment)
(script# 50)
(include sci.sh)
(use Main)
(use EcoFeature)
(use RTRandCycle)
(use Cycle)
(use Game)
(use Obj)

(public
	regionFish 0
)

(local
	[local0 33] = [0 0 0 54 42 45 57 46 49 60 51 53 63 56 57 66 58 59 69 60 61 72 62 63 75 64 65 78 66 67 81 68 69]
	[local33 6]
)
(class regionFish of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		pts 0
		size 0
	)
	
	(method (init)
		(super init: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(= initialized (= keep 0))
		(self sushi:)
		(super newRoom: newRoomNumber &rest)
	)
	
	(method (addFish param1 &tmp temp0)
		(= temp0 0)
		(while
			(and
				(< temp0 argc)
				(< size 6)
				(or (not size) (< size global87))
			)
			(= [local33 size] (Clone Fish))
			([local33 size] mPts: [param1 temp0] init:)
			(++ size)
			(++ temp0)
		)
	)
	
	(method (sushi)
		(if size
			(-- size)
			(while size
				([local33 size] dispose:)
				(-- size)
			)
		)
	)
)

(class Fish of EcoActor
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
		signal $6000
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
		mPts 0
		ptsPtr 0
		fishNumber 0
		pathContinue 1
		seconds 0
		lastSeconds 0
	)
	
	(method (init)
		(self setupFish:)
		(super init: &rest)
		(self startMove:)
	)
	
	(method (doit &tmp theLastSeconds)
		(if
			(and
				seconds
				(!= lastSeconds (= theLastSeconds (GetTime 1)))
			)
			(= lastSeconds theLastSeconds)
			(if (not (-- seconds)) (self cue:))
		)
		(super doit:)
	)
	
	(method (doVerb theVerb &tmp theTheVerb [temp1 500] temp501)
		(= temp501 global251)
		(= global251 1)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(EcoNarrator init: 1 0 0 (Random 1 8) 0 50)
			)
			(44
				(switch theTheVerb
					(29
						(EcoNarrator init: 1 0 0 (Random 9 12) 0 50)
					)
					(17
						(EcoNarrator init: 1 0 0 (Random 13 16) 0 50)
					)
					(30
						(EcoNarrator init: 1 0 0 (Random 17 20) 0 50)
					)
					(37
						(EcoNarrator init: 1 0 0 (Random 20 24) 0 50)
					)
					(12
						(EcoNarrator init: 1 0 0 (Random 25 28) 0 50)
					)
					(36
						(EcoNarrator init: 1 0 0 (Random 29 32) 0 50)
					)
					(else 
						(EcoNarrator init: 1 0 0 (Random 37 41) 0 50)
					)
				)
			)
			(6
				(EcoNarrator init: 1 0 0 (Random 33 36) 0 50)
			)
			(1
				(if (and (proc999_5 gNumber 440 480) (Random 0 1))
					(EcoNarrator init: 1 0 0 (+ 70 (Random 0 1)))
				else
					(EcoNarrator
						init: 1 0 0 [local0 (+ (- view 51) fishNumber 1)] 0 50
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
		(= global251 temp501)
	)
	
	(method (cue &tmp temp0)
		(if
			(!=
				(= temp0 (proc999_6 mPts (= ptsPtr (+ ptsPtr 2))))
				8192
			)
			(if (== temp0 4096)
				(self setPri: (proc999_6 mPts (+ ptsPtr 1)))
				(= temp0 (proc999_6 mPts (= ptsPtr (+ ptsPtr 2))))
			)
			(if (== temp0 -32768) (= pathContinue 0))
			(if (not (proc999_5 temp0 16384 -32768))
				(self
					setMotion:
						FishMover
						(proc999_6 mPts ptsPtr)
						(proc999_6 mPts (+ ptsPtr 1))
						self
				)
			else
				(if (not pathContinue) (self setupFish:))
				(self startMove:)
			)
		else
			(= seconds
				(if
				(!= (= temp0 (proc999_6 mPts (+ ptsPtr 1))) -1)
					temp0
				else
					(Random 1 5)
				)
			)
			(self setCycle: Fwd)
		)
	)
	
	(method (setupFish &tmp temp0 temp1)
		(self
			view:
				(if (!= (= temp1 (proc999_6 mPts 0)) -1)
					temp1
				else
					(+ (* (Random 1 10) 3) 51)
				)
			fishNumber:
				(if (!= (= temp0 (proc999_6 mPts 1)) -1)
					temp0
				else
					(Random 0 1)
				)
			posn: (proc999_6 mPts 2) (proc999_6 mPts 3)
			setPri: (proc999_6 mPts 4)
			setCycle: Walk
		)
	)
	
	(method (startMove)
		(self
			setCycle: Walk
			setMotion:
				FishMover
				(proc999_6 mPts (= ptsPtr 5))
				(proc999_6 mPts (+ ptsPtr 1))
				self
		)
	)
)

(class FishMover of MoveTo
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
	)
	
	(method (init)
		(super init: &rest)
		(client
			setLoop: (+ (* (client fishNumber?) 2) (< x (client x?)))
		)
	)
)
